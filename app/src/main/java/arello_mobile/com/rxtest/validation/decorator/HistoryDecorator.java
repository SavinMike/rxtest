package arello_mobile.com.rxtest.validation.decorator;

import java.util.LinkedList;

/**
 * Date: 24.11.2015
 * Time: 12:44
 *
 * @author Savin Mikhail
 */
public abstract class HistoryDecorator<T> implements Decorator<T>
{
	private LinkedList<T> mHistory = new LinkedList<>();

	@Override
	public void decorate(final T decorated)
	{
		mHistory.add(decorated);
		decorate(mHistory, decorated);
	}

	//Do not add decorated to historyList
	protected abstract void decorate(final LinkedList<T> historyList, T decorated);

	@Override
	public void reset(final T decorated)
	{
		mHistory.remove(decorated);
		reset(mHistory, decorated);
	}

	//Do not remove decorated to historyList
	protected abstract void reset(final LinkedList<T> historyList, T decorated);
}
