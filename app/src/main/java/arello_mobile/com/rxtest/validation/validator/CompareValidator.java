package arello_mobile.com.rxtest.validation.validator;

import android.text.TextUtils;
import android.widget.TextView;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

public class CompareValidator extends TextViewValidator
{

	private TextView[] mCompareTextViews;

	public CompareValidator(final Decorator<TextView> decorator, final TextView textView, TextView... others)
	{
		super(decorator, textView);
		mCompareTextViews = others;
	}


	@Override
	protected boolean isValid()
	{
		if (mCompareTextViews == null)
		{
			return true;
		}

		for (TextView compare : mCompareTextViews)
		{
			if ((!TextUtils.isEmpty(getText(compare)) || !TextUtils.isEmpty(getText())) && (getText(compare) == null || !getText().equals(getText(compare))))
			{
				return false;
			}
		}

		return true;
	}
}