package es.solusoft.example_sdk_login;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class LoggedActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authorized);
		
		/* 
		 * CONGRATULATIONS!
		 * The user is logged in your app 
		 * 
		 * 
		 * Now you can Retrieve the current saved access token
		 * 
		 *      topoos.AccessTokenOAuth.GetAccessToken(this);
		 * 
		 * Or you can perform API Calls
		 * 
		 *      User currentUser = topoos.Users.Operations.Get(this, "me");
		 * 
		 */
	}


	public void onLogOutClick(View v) {
		if (v.getId() == R.id.buttonLogOut) {

			//We must Log Out the current user by deleting the saved token
			topoos.AccessTokenOAuth.DeleteAccessToken(this);
			
			Toast.makeText(this, getString(R.string.user_logged_out), Toast.LENGTH_SHORT).show();
			
			//Then go to login activity again
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			this.finish();
			
		}
	}

}
