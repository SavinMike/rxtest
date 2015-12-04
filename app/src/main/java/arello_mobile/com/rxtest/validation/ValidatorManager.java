package arello_mobile.com.rxtest.validation;

import java.util.LinkedList;
import java.util.List;

import arello_mobile.com.rxtest.validation.validator.Validator;

public class ValidatorManager
{
	private final List<Validator> mValidators = new LinkedList<>();

	public ValidatorManager()
	{/*do nothing*/}

	public void addValidator(Validator validator)
	{
		mValidators.add(validator);
	}

	public void removeValidate(Validator validator)
	{
		mValidators.remove(validator);
	}

	public void clear()
	{
		mValidators.clear();
	}

	public boolean validateSeries()
	{
		boolean isValid = true;

		for (Validator validator : mValidators)
		{
			if (!(isValid = validate(isValid, validator)))
			{
				validator.resetDecorator();
			}
		}

		return isValid;
	}

	public boolean validateAll()
	{
		boolean isValid = true;

		for (Validator validator : mValidators)
		{
			isValid = validate(isValid, validator);
		}

		return isValid;
	}

	public void resetAll()
	{
		for (Validator validator : mValidators)
		{
			validator.resetDecorator();
		}
	}

	private <T> boolean validate(boolean isValid, final Validator<T> validator)
	{
		final boolean validate = validator.validate();
		if (!validate)
		{
			isValid = false;
		}
		return isValid;
	}
}