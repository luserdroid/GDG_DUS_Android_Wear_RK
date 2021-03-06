package com.luser.android.wear;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.luser.android.wear.notification.NotificationManagerHelper;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		String notruf = "Notruf";
		String service = "Service";
		String contacts = "Kontakte";
		
		NotificationManagerHelper notificationHelper = new NotificationManagerHelper(
				MainActivity.class, this);
		notificationHelper.createNotification(R.drawable.ic_launcher, notruf,
				"Kontakte benachrichtigen ","test", 1);
		notificationHelper.createNotification(R.drawable.ic_launcher, service,
				"Service benachrichtigen ","test", 2);
		notificationHelper.createNotification(R.drawable.ic_launcher, contacts,
				"Notruf benachrichtigen ","test", 3);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (NotificationManagerHelper.RESULT_CODE_NOTIFICATION == requestCode) {
			Log.i("asfd", "sdf");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
