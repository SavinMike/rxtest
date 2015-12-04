package arello_mobile.com.rxtest.validation.validator;


import android.text.TextUtils;
import android.widget.TextView;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

public class EmptyValidator extends TextViewValidator {


    public EmptyValidator(final Decorator<TextView> decorator, final TextView textView)
    {
        super(decorator, textView);
    }

    @Override
    protected boolean isValid()
    {
        return !TextUtils.isEmpty(getText());
    }
}
