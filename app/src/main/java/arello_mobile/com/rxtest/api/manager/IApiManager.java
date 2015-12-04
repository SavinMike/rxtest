package arello_mobile.com.rxtest.api.manager;

import com.google.gson.Gson;

import arello_mobile.com.rxtest.api.generator.ApiGenerator;

/**
 * Date: 24.06.2015
 * Time: 14:40
 *
 * @author Savin Mikhail
 */
public interface IApiManager
{
	<T, F extends ApiGenerator<T>> T getApi(final F type);

	void generateRestAdapter(Gson gson);
}
