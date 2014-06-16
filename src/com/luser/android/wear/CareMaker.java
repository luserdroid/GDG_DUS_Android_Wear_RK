package com.luser.android.wear;

import com.luser.android.wear.notification.NotificationManagerHelper;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigTextStyle;

public class CareMaker {

	private Context context;
	private Class clzz;

	public CareMaker(Context context, Class clzz) {
		this.context = context;
		this.clzz = clzz;
	}

	public void showCareNotifications() {
		final NotificationManagerHelper notificationHelper = new NotificationManagerHelper(
				clzz, context);

		// contact
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				notificationHelper.createNotification(R.drawable.ic_launcher,
						R.string.notification_contact,
						R.string.notification_contact_caretaker,
						NotificationManagerHelper.GROUP_CONTACT);
			}
		}, 1000);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// emergency
				notificationHelper.createNotification(R.drawable.ic_launcher,
						R.string.notification_emergency,
						R.string.notification_emergency_ambulance,
						NotificationManagerHelper.GROUP_EMERGENCY);
			}
		}, 2000);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// service
				notificationHelper.createNotification(R.drawable.ic_launcher,
						R.string.notification_service,
						R.string.notification_service_sanitary,
						NotificationManagerHelper.GROUP_SERVICE);
			}
		}, 3000);
	}
}
