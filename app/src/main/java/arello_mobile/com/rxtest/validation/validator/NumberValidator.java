package arello_mobile.com.rxtest.validation.validator;

import android.widget.TextView;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

/**
 * Date: 03.12.2015
 * Time: 18:35
 *
 * @author Savin Mikhail
 */
public class NumberValidator extends PatternValidator
{
	public NumberValidator(final Decorator<TextView> decorator, final TextView textView, final int count)
	{
		super(decorator, textView, String.format("^.{%s,}$", count));
	}
}
