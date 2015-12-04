package arello_mobile.com.rxtest.api.model.response;

import java.util.List;

/**
 * Date: 03.12.2015
 * Time: 18:08
 *
 * @author Savin Mikhail
 */
public class AuthResponse extends Response
{

	public int mId;
	public String mUrl;
	public App mApp;
	public String mToken;
	public String mHashedToken;
	public String mTokenLastEight;
	public String mNote;
	public String mNoteUrl;
	public String mCreatedAt;
	public String mUpdatedAt;
	public List<String> mScopes;
	public String mFingerprint;

	public static class App
	{
		public String mName;
		public String mUrl;
		public String mClientId;

		@Override
		public String toString()
		{
			return "App{" +
					"mName='" + mName + '\'' +
					", mUrl='" + mUrl + '\'' +
					", mClientId='" + mClientId + '\'' +
					'}';
		}
	}

	@Override
	public String toString()
	{
		return "AuthResponse{" +
				"mId=" + mId +
				", mUrl='" + mUrl + '\'' +
				", mApp=" + mApp +
				", mToken='" + mToken + '\'' +
				", mHashedToken='" + mHashedToken + '\'' +
				", mTokenLastEight='" + mTokenLastEight + '\'' +
				", mNote='" + mNote + '\'' +
				", mNoteUrl='" + mNoteUrl + '\'' +
				", mCreatedAt='" + mCreatedAt + '\'' +
				", mUpdatedAt='" + mUpdatedAt + '\'' +
				", mScopes=" + mScopes +
				", mFingerprint='" + mFingerprint + '\'' +
				'}';
	}
}
