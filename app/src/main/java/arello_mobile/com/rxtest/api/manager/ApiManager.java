package arello_mobile.com.rxtest.api.manager;

import android.content.Context;

import com.google.gson.Gson;

import arello_mobile.com.rxtest.BuildConfig;
import arello_mobile.com.rxtest.R;
import arello_mobile.com.rxtest.api.generator.ApiGenerator;
import arello_mobile.com.rxtest.app.RxTestApplication;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import static java.lang.String.format;

/**
 * Date: 24.06.2015
 * Time: 14:33
 *
 * @author Savin Mikhail
 */
@SuppressWarnings({"PointlessBooleanExpression", "ConstantConditions"})
public class ApiManager implements IApiManager
{
	private final String mBaseUrl;
	private final Context mContext;
	private RestAdapter mRestAdapter;

	public ApiManager(Context context)
	{
		mBaseUrl = context.getString(R.string.base_url);
		mContext = context;
	}

	@Override
	public <T, F extends ApiGenerator<T>> T getApi(final F type)
	{
		return type.getApi(mRestAdapter);
	}

	@Override
	public void generateRestAdapter(Gson gson)
	{
		mRestAdapter = new RestAdapter.Builder()
				.setEndpoint(mBaseUrl)
				.setConverter(new GsonConverter(gson))
				.setRequestInterceptor(requestFacade -> {
					requestFacade.addHeader("Accept-Language", mContext.getResources().getConfiguration().locale.getLanguage());
					final String token = RxTestApplication.getToken(mContext);
					if (token != null)
					{
						requestFacade.addHeader("Authorization", format("token %s", token));
					}
					else if (RxTestApplication.getAuth(mContext) != null)
					{
						requestFacade.addHeader("Authorization", format("Basic %s", RxTestApplication.getAuth(mContext)));
					}
				})
				.setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
				.build();
	}
}
