package arello_mobile.com.rxtest.api.model.request;

import java.util.Collections;
import java.util.List;

/**
 * Date: 03.12.2015
 * Time: 19:15
 *
 * @author Savin Mikhail
 */
public class AuthRequest
{

	public List<String> mScopes;
	public String mNote;

	public AuthRequest()
	{
		mNote = String.valueOf(System.currentTimeMillis());
		mScopes = Collections.singletonList("public_repo");
	}

	@Override
	public String toString()
	{
		return "AuthRequest{" +
				"mScopes=" + mScopes +
				", mNote='" + mNote + '\'' +
				'}';
	}
}
