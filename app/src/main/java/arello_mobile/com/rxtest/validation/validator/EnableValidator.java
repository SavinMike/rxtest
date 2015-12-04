package arello_mobile.com.rxtest.validation.validator;

import android.view.View;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

/**
 * Date: 20.11.2015
 * Time: 17:36
 *
 * @author Savin Mikhail
 */
public class EnableValidator<T extends View> extends Validator<T>
{

	public EnableValidator(final Decorator<T> decorator, final T view)
	{
		super(decorator, view);
	}

	@Override
	protected boolean isValid()
	{
		return getValidate().isEnabled();
	}
}
