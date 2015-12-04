package arello_mobile.com.rxtest.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import arello_mobile.com.rxtest.api.manager.ApiManager;

/**
 * Date: 03.12.2015
 * Time: 18:05
 *
 * @author Savin Mikhail
 */
public class RxTestApplication extends Application
{
	public static ApiManager getApiManager(Context context)
	{
		return (getApplicationContext(context)).mApiManager;
	}

	@Nullable
	public static String getToken(Context context)
	{
		return getApplicationContext(context).mToken;
	}

	public static void setToken(Context context, final String token)
	{
		getApplicationContext(context).mToken = token;
	}

	@Nullable
	public static String getAuth(Context context)
	{
		return getApplicationContext(context).mBase64Auth;
	}

	public static void setAuth(Context context, final String userName, String email)
	{
		getApplicationContext(context).mBase64Auth = Base64.encodeToString(String.format("%s:%s", userName, email).getBytes(), Base64.DEFAULT).trim();
	}

	private static RxTestApplication getApplicationContext(final Context context)
	{
		return (RxTestApplication) context.getApplicationContext();
	}

	private ApiManager mApiManager;
	private String mToken;
	private String mBase64Auth;

	@Override
	public void onCreate()
	{
		super.onCreate();

		generateManager();
	}

	private void generateManager()
	{
		mApiManager = new ApiManager(this);
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.serializeNulls()
				.setFieldNamingStrategy(new GsonNameStrategy())
				.create();

		mApiManager.generateRestAdapter(gson);
	}
}
