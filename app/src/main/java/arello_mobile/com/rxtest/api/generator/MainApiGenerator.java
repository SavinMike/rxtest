package arello_mobile.com.rxtest.api.generator;

import arello_mobile.com.rxtest.api.GitApi;

/**
 * Date: 05.10.2015
 * Time: 14:23
 *
 * @author Savin Mikhail
 */
public class MainApiGenerator<T> extends BaseApiGenerator<T>
{
	public static MainApiGenerator<GitApi> GIT = new MainApiGenerator<>(GitApi.class);

	protected MainApiGenerator(final Class<T> aClass)
	{
		super(aClass);
	}
}
