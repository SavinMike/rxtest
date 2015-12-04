package arello_mobile.com.rxtest.validation.validator;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComboValidator<T> extends Validator<T> {

    private final Set<Validator<T>> mValidators = new LinkedHashSet<>();

    public ComboValidator()
    {
        super(null, null);
    }

    public boolean addValidator(Validator<T> validator) {
        return mValidators.add(validator);
    }

    public boolean removeValidator(Validator<T> validator) {
        return mValidators.remove(validator);
    }

    public void removeAll() {
        mValidators.clear();
    }

    @Override
    public void resetDecorator()
    {
        for(Validator<T> validator: mValidators){
            validator.resetDecorator();
        }
    }

    @Override
    protected boolean isValid()
    {
        for (Validator<T> validator : mValidators) {
            if(!validator.validate()) {
                setValidate(validator.getValidate());
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean validate()
    {
        return isValid();
    }
}