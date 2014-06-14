package com.luser.android.wear;

import com.luser.android.wear.notification.NotificationManagerHelper;

import android.app.Notification;
import android.content.Context;

public class CareMaker {

	private Context context;
	private Class clzz;
	public CareMaker(Context context, Class clzz){
		this.context = context;
		this.clzz = clzz;
	}
	
	public void showCareNotifications(){
		NotificationManagerHelper notificationHelper = new NotificationManagerHelper(clzz,
				context);

		Notification notification = notificationHelper.createNotification(
				R.drawable.ic_launcher, R.string.notification_contact,
				R.string.notification_contact_caretaker,NotificationManagerHelper.GROUP_CONTACT);
		notificationHelper.triggerNotification(notification, NotificationManagerHelper.CONTACT);

		notification = notificationHelper.createNotification(R.drawable.ic_launcher,
				R.string.notification_emergency,
				R.string.notification_emergency_ambulance,NotificationManagerHelper.GROUP_EMERGENCY);
		notificationHelper.triggerNotification(notification, NotificationManagerHelper.EMERGENCY);
		
		notification = notificationHelper.createNotification(R.drawable.ic_launcher,
				R.string.notification_service,
				R.string.notification_service_sanitary,NotificationManagerHelper.GROUP_SERVICE);
		notificationHelper.triggerNotification(notification, NotificationManagerHelper.SERVICE);
	}
}
