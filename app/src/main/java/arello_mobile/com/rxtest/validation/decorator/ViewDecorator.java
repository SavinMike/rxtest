package arello_mobile.com.rxtest.validation.decorator;

import android.view.View;

/**
 * Date: 20.11.2015
 * Time: 17:16
 *
 * @author Savin Mikhail
 */
public class ViewDecorator<T> implements Decorator<T>
{
	private final View mView;
	private final int mVisibility;
	private final int mResetVisibility;

	public ViewDecorator(final View view)
	{
		mView = view;
		mVisibility = View.VISIBLE;
		mResetVisibility = View.GONE;
	}

	public ViewDecorator(final View view, final int resetVisibility)
	{
		mView = view;
		mVisibility = View.VISIBLE;
		mResetVisibility = resetVisibility;
	}

	public ViewDecorator(final View view, final int visibility, final int resetVisibility)
	{
		mView = view;
		mVisibility = visibility;
		mResetVisibility = resetVisibility;
	}

	@Override
	public void decorate(final T textView)
	{
		mView.setVisibility(mVisibility);
	}

	@Override
	public void reset(final T textView)
	{
		mView.setVisibility(mResetVisibility);
	}
}
