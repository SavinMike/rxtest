package arello_mobile.com.rxtest.validation.validator;


import android.util.Patterns;
import android.widget.TextView;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

public class EmailValidator extends PatternValidator
{

	public EmailValidator(final Decorator<TextView> decorator, final TextView textView)
	{
		super(decorator, textView, Patterns.EMAIL_ADDRESS.pattern());
	}
}
