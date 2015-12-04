package arello_mobile.com.rxtest.validation.decorator;

import android.widget.TextView;

/**
 * Date: 23.11.2015
 * Time: 10:16
 *
 * @author Savin Mikhail
 */
public class TextUpdateDecorator implements Decorator<TextView>
{
	private final CharSequence mDefString;
	private final CharSequence mDecorateString;
	private final TextView mDecorateTextView;

	public TextUpdateDecorator(final CharSequence defString, final CharSequence decorateString, final TextView decorateTextView)
	{
		mDefString = defString;
		mDecorateString = decorateString;
		mDecorateTextView = decorateTextView;
	}

	@Override
	public void decorate(final TextView decorated)
	{
		mDecorateTextView.setText(mDecorateString);
	}

	@Override
	public void reset(final TextView decorated)
	{
		mDecorateTextView.setText(mDefString);
	}
}
