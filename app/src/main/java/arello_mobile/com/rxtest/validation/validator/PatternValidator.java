package arello_mobile.com.rxtest.validation.validator;

import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

public class PatternValidator extends TextViewValidator {

    private String mStringPattern;

    public PatternValidator(final Decorator<TextView> decorator, final TextView textView, final String stringPattern)
    {
        super(decorator, textView);
        mStringPattern = stringPattern;
    }

    @Override
    protected boolean isValid()
    {
        if(getText() == null){
            return false;
        }

        Pattern pattern = Pattern.compile(mStringPattern);
        Matcher matcher = pattern.matcher(getText());

        return matcher.matches();
    }
}