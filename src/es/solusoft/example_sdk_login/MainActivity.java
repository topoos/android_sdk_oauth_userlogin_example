package es.solusoft.example_sdk_login;

import topoos.AccessTokenOAuth;
import topoos.LoginActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {

	private static String CLIENT_ID = "XXXXXXXXXXXXXXXXX"; //REPLACE_WITH_YOUR_CLIENT_ID;
	
	private int REQUESTCODE_LOGIN = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Check the pre-saved AccesTokenOAuth (is the user recurrent?)
		AccessTokenOAuth currentToken = topoos.AccessTokenOAuth.GetAccessToken(this);
		if (currentToken != null && currentToken.isValid())
		{
			//We have a valid token, the user is currently logged in
			goToLoggedInActivity();
		}else
		{
			//The user is not logged in
			setContentView(R.layout.activity_main);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		findViewById(R.id.button).setOnClickListener(this);
	}

	public void onClick(View v) {
		if (v.getId() == R.id.button) {
			Intent intent = new Intent(this, LoginActivity.class);
			intent.putExtra(LoginActivity.CLIENT_ID, CLIENT_ID);
			startActivityForResult(intent, REQUESTCODE_LOGIN);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUESTCODE_LOGIN) {
			switch (resultCode) {
			case LoginActivity.RESULT_OK:
				if (AccessTokenOAuth.GetAccessToken(getApplicationContext()).isValid()) {
					//We have a valid token
					goToLoggedInActivity();
				}
				break;
			case LoginActivity.RESULT_CANCELED:
				if (!AccessTokenOAuth.GetAccessToken(getApplicationContext()).isValid()) {
					((TextView) findViewById(R.id.access)).setText(R.string.not_valid);
				}
				break;
			case LoginActivity.RESULT_TOPOOSERROR:
				if (!AccessTokenOAuth.GetAccessToken(getApplicationContext()).isValid()) {
					((TextView) findViewById(R.id.access)).setText(R.string.not_valid);
				}
				break;
			default:
				break;
			}
		}
	}

	/**
	 * The user is logged in your app, you can continue
	 */
	private void goToLoggedInActivity()
	{
		Intent intent = new Intent(this, LoggedActivity.class);
		startActivity(intent);
		this.finish();
	}
}
