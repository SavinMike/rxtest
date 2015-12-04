package arello_mobile.com.rxtest.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import arello_mobile.com.rxtest.R;
import arello_mobile.com.rxtest.api.GitApi;
import arello_mobile.com.rxtest.api.generator.MainApiGenerator;
import arello_mobile.com.rxtest.api.model.request.AuthRequest;
import arello_mobile.com.rxtest.app.RxTestApplication;
import arello_mobile.com.rxtest.validation.ValidatorManager;
import arello_mobile.com.rxtest.validation.decorator.TextErrorDecorator;
import arello_mobile.com.rxtest.validation.validator.EmailValidator;
import arello_mobile.com.rxtest.validation.validator.NumberValidator;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity
{

	@Bind(R.id.activity_main_edit_text_username)
	EditText mEditTextUsername;
	@Bind(R.id.activity_main_edit_text_password)
	EditText mEditTextPassword;
	@Bind(R.id.activity_main_button_login)
	Button mButtonLogin;

	private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

	private ValidatorManager mValidatorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		initValidator();
		mCompositeSubscription.add(generateSubscription());
	}

	private void initValidator()
	{
		mValidatorManager = new ValidatorManager();
		mValidatorManager.addValidator(new EmailValidator(new TextErrorDecorator("Invalid email!"), mEditTextUsername));
		mValidatorManager.addValidator(new NumberValidator(new TextErrorDecorator("Password must be more then 8 symbols!"), mEditTextPassword, 8));
	}

	private Subscription generateSubscription()
	{
		return Observable.combineLatest(
				RxTextView.textChanges(mEditTextUsername).skip(1),
				RxTextView.textChanges(mEditTextPassword).skip(1),
				(email, password) -> {
					final boolean result = mValidatorManager.validateAll();
					if (result)
					{
						RxTestApplication.setAuth(MainActivity.this, email.toString(), password.toString());
					}
					return result;
				}
		).doOnNext(mButtonLogin::setEnabled).filter(valid -> valid).flatMap(aBoolean -> RxView.clicks(mButtonLogin).map(o -> new AuthRequest()))
				.doOnNext(req -> mButtonLogin.setEnabled(false)).switchMap(req ->
						getApi().login(req)
								.observeOn(AndroidSchedulers.mainThread())
								.onErrorResumeNext(error -> {
									Snackbar.make(mButtonLogin, error.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
									mButtonLogin.setEnabled(true);
									return Observable.empty();
								})
								.doOnNext(authResponse -> Toast.makeText(getApplication(), authResponse.toString(), Toast.LENGTH_LONG).show()))
				.subscribe(req -> Toast.makeText(getApplicationContext(), req.toString(), Toast.LENGTH_LONG).show());
	}

	private GitApi getApi()
	{
		return RxTestApplication.getApiManager(this).getApi(MainApiGenerator.GIT);
	}
}
