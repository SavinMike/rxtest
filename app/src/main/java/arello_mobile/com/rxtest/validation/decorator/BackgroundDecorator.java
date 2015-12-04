package arello_mobile.com.rxtest.validation.decorator;

import android.view.View;


public class BackgroundDecorator<T extends View> implements Decorator<T> {

    private final int mDefaultBackground;
    private final int mInvalidBackground;

    public BackgroundDecorator(int defaultBackgroundResource, int invalidBackgroundResource) {
        mDefaultBackground = defaultBackgroundResource;
        mInvalidBackground = invalidBackgroundResource;
    }

    @Override
    public void decorate(final View view)
    {
        view.setBackgroundResource(mInvalidBackground);
    }

    @Override
    public void reset(final View textView)
    {
        textView.setBackgroundResource(mDefaultBackground);
    }
}