package arello_mobile.com.rxtest.validation.decorator;

import android.view.View;
import android.widget.ScrollView;

import java.util.LinkedList;

/**
 * Date: 24.11.2015
 * Time: 10:54
 *
 * @author Savin Mikhail
 */
public class ViewFocusDecorator<T extends View> extends HistoryDecorator<T>
{
	private ScrollView mScrollView;
	private boolean mFirstInvalid;
	private T mDecorated;

	public ViewFocusDecorator(final ScrollView scrollView)
	{
		mScrollView = scrollView;
	}

	public ViewFocusDecorator()
	{/*do nothing*/}

	private void scrollTo(View view)
	{
		int top = view.getTop();
		mScrollView.smoothScrollTo(mScrollView.getScrollX(), top);
	}

	@Override
	protected void decorate(final LinkedList<T> historySet, T decorated)
	{
		if (!mFirstInvalid || decorated.equals(mDecorated))
		{
			mFirstInvalid = true;
			mDecorated = decorated;
			mDecorated.requestFocus();

			if (mScrollView != null)
			{
				scrollTo(mDecorated);
			}
		}
	}

	public boolean isFirstInvalid()
	{
		return mFirstInvalid;
	}

	@Override
	protected void reset(final LinkedList<T> historySet, T decorated)
	{
		if (mFirstInvalid && mDecorated.equals(decorated))
		{
			mDecorated.clearFocus();
			if (mScrollView != null)
			{
				mScrollView.smoothScrollTo(0, 0);
			}

			mFirstInvalid = false;
			mDecorated = null;
		}
	}
}
