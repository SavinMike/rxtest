package arello_mobile.com.rxtest.api.generator;

import retrofit.RestAdapter;

/**
 * Date: 06.10.2015
 * Time: 10:02
 *
 * @author Savin Mikhail
 */
class BaseApiGenerator<T> implements ApiGenerator<T>
{

	Class<T> mClass;
	T mApi;

	BaseApiGenerator(final Class<T> aClass)
	{
		mClass = aClass;
	}

	@Override
	public Class<T> getApiClass()
	{
		return mClass;
	}

	@Override
	public T getApi(RestAdapter restAdapter)
	{
		if (mApi != null)
		{
			return mApi;
		}

		mApi = restAdapter.create(getApiClass());
		return mApi;
	}
}
