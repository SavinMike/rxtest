package arello_mobile.com.rxtest.validation.validator;

import android.support.annotation.Nullable;
import android.widget.TextView;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

/**
 * Date: 23.11.2015
 * Time: 9:54
 *
 * @author Savin Mikhail
 */
public abstract class TextViewValidator extends Validator<TextView>
{
	public TextViewValidator(final Decorator<TextView> decorator, final TextView validate)
	{
		super(decorator, validate);
	}

	@Nullable
	protected String getText()
	{
		return getText(getValidate());
	}

	@Nullable
	protected String getText(TextView textView)
	{
		if (textView == null)
		{
			return null;
		}

		return textView.getText().toString().trim();
	}
}
