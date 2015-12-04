package arello_mobile.com.rxtest.validation.decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComboDecorator<T> implements Decorator<T>
{

	private final List<Decorator<T>> mDecorators = new ArrayList<>();

	public ComboDecorator(Decorator<T>... decorators)
	{
		if (decorators != null)
		{
			mDecorators.addAll(Arrays.asList(decorators));
		}
	}

	public boolean addDecorator(Decorator<T> decorator)
	{
		return mDecorators.add(decorator);
	}

	public boolean removeDecorator(Decorator<T> decorator)
	{
		return mDecorators.remove(decorator);
	}

	public void removeAll()
	{
		mDecorators.clear();
	}

	@Override
	public void decorate(final T textView)
	{
		for (Decorator<T> decorator : mDecorators)
		{
			decorator.decorate(textView);
		}
	}

	@Override
	public void reset(final T textView)
	{
		for (Decorator<T> decorator : mDecorators)
		{
			decorator.reset(textView);
		}
	}
}
