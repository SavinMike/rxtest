package arello_mobile.com.rxtest.validation.decorator;

import android.widget.TextView;

/**
 * Date: 03.12.2015
 * Time: 18:31
 *
 * @author Savin Mikhail
 */
public class TextErrorDecorator implements Decorator<TextView>
{
	private String mError;

	public TextErrorDecorator(final String error)
	{
		mError = error;
	}

	@Override
	public void decorate(final TextView decorated)
	{
		decorated.setError(mError);
	}

	@Override
	public void reset(final TextView decorated)
	{
		decorated.setError(null);
	}
}
