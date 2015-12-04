package arello_mobile.com.rxtest.api.generator;

import retrofit.RestAdapter;

/**
 * Date: 05.10.2015
 * Time: 14:22
 *
 * @author Savin Mikhail
 */
public interface ApiGenerator<T>
{
	Class<T> getApiClass();

	T getApi(RestAdapter restAdapter);
}
