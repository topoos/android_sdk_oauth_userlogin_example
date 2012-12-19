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
	private static String CLIENT_ID = "XXXXXXXXXXXXXXXXXXXX";
	private int REQUESTCODE_LOGIN = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onResume() {
		super.onResume();
		findViewById(R.id.button).setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
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
				if (AccessTokenOAuth.GetAccessToken(getApplicationContext())
						.isValid()) {
					((TextView) findViewById(R.id.access))
							.setText(R.string.valid);
				}
				break;
			case LoginActivity.RESULT_CANCELED:
				if (!AccessTokenOAuth.GetAccessToken(getApplicationContext())
						.isValid()) {
					((TextView) findViewById(R.id.access))
							.setText(R.string.not_valid);
				}
				break;
			case LoginActivity.RESULT_TOPOOSERROR:
				if (!AccessTokenOAuth.GetAccessToken(getApplicationContext())
						.isValid()) {
					((TextView) findViewById(R.id.access))
							.setText(R.string.not_valid);
				}
				break;
			default:
				break;
			}
		}
	}

}
