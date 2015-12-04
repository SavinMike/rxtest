package arello_mobile.com.rxtest.app;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

/**
 * Date: 01.10.2015
 * Time: 13:05
 *
 * @author Savin Mikhail
 */
public class GsonNameStrategy implements FieldNamingStrategy
{
	private static String separateCamelCase(String name, String separator)
	{
		StringBuilder translation = new StringBuilder();
		for (int i = 0; i < name.length(); i++)
		{
			char character = name.charAt(i);
			if (Character.isUpperCase(character) && translation.length() != 0)
			{
				translation.append(separator);
			}
			translation.append(character);
		}
		return translation.toString();
	}

	@Override
	public String translateName(final Field f)
	{
		String name = f.getName();

		if (name.startsWith("m"))
		{
			name = name.substring(1);
		}

		return separateCamelCase(name, "_").toLowerCase();
	}
}
