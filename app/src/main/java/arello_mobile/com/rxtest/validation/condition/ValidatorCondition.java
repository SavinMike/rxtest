package arello_mobile.com.rxtest.validation.condition;

/**
 * Date: 24.11.2015
 * Time: 10:36
 *
 * @author Savin Mikhail
 */
public interface ValidatorCondition
{
	boolean needDecorate(boolean isValid);

	void clear();
}
