package arello_mobile.com.rxtest.validation.decorator;

/**
 * Date: 20.11.2015
 * Time: 16:46
 *
 * @author Savin Mikhail
 */
public interface Decorator<T>
{

	void decorate(T decorated);

	void reset(T decorated);
}
