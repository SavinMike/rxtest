package arello_mobile.com.rxtest.validation.condition;

/**
 * Date: 24.11.2015
 * Time: 10:37
 *
 * @author Savin Mikhail
 */
public class FirstInvalidCondition implements ValidatorCondition
{
	private boolean mFirstInvalidCondition;

	@Override
	public boolean needDecorate(final boolean isValid)
	{
		if (!mFirstInvalidCondition)
		{
			mFirstInvalidCondition = !isValid;
			return mFirstInvalidCondition;
		}

		return false;
	}

	@Override
	public void clear()
	{
		mFirstInvalidCondition = false;
	}
}
