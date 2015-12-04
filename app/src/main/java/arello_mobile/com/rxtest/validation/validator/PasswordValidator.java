package arello_mobile.com.rxtest.validation.validator;

import android.widget.TextView;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

/**
 * Date: 23.11.2015
 * Time: 10:19
 *
 * @author Savin Mikhail
 */
public class PasswordValidator extends TextViewValidator
{
	public PasswordValidator(final Decorator<TextView> decorator, final TextView validate)
	{
		super(decorator, validate);
	}

	@Override
	protected boolean isValid()
	{
		return getText() != null && getText().length() > 8 && getText().matches("\\d*") && getText().matches(".*[a-z].*") && getText().matches(".*[A-Z].*") && getText().matches(".*?\\d.*");

	}
}
