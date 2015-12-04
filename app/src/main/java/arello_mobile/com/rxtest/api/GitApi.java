package arello_mobile.com.rxtest.api;

import arello_mobile.com.rxtest.api.model.request.AuthRequest;
import arello_mobile.com.rxtest.api.model.response.AuthResponse;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Date: 03.12.2015
 * Time: 17:57
 *
 * @author Savin Mikhail
 */
public interface GitApi
{
	@POST("/authorizations")
	Observable<AuthResponse> login(@Body AuthRequest authRequest);
}
