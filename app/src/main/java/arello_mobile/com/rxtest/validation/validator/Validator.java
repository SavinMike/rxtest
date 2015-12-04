package arello_mobile.com.rxtest.validation.validator;

import android.support.annotation.NonNull;

import arello_mobile.com.rxtest.validation.decorator.Decorator;

/**
 * Date: 20.11.2015
 * Time: 16:45
 *
 * @author Savin Mikhail
 */
public abstract class Validator<T>
{
	private Decorator<T> mDecorator;
	private T mValidate;

	public Validator(final Decorator<T> decorator, final @NonNull T validate)
	{
		mDecorator = decorator;
		mValidate = validate;
	}

	protected abstract boolean isValid();

	@NonNull
	public T getValidate()
	{
		return mValidate;
	}

	protected Validator setValidate(final T validate)
	{
		mValidate = validate;
		return this;
	}

	public void resetDecorator()
	{
		mDecorator.reset(mValidate);
	}

	public boolean validate()
	{
		boolean result = isValid();
		if (!result)
		{
			mDecorator.decorate(mValidate);
		}
		else
		{
			mDecorator.reset(mValidate);
		}

		return result;
	}
}
