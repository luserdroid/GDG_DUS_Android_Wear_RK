package com.luser.android.wear;

import com.luser.android.wear.notification.NotificationManagerHelper;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigTextStyle;

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

		//contact
		Notification notification = notificationHelper.createNotification(
				R.drawable.ic_launcher, R.string.notification_contact,
				R.string.notification_contact_caretaker,NotificationManagerHelper.GROUP_CONTACT, null);
		notificationHelper.triggerNotification(notification, NotificationManagerHelper.CONTACT);

		//emergency
		Notification page = notificationHelper.createPage(R.string.notification_emergency_description_title, R.string.notification_emergency_description);
		notification = notificationHelper.createNotification(R.drawable.ic_launcher,
				R.string.notification_emergency,
				R.string.notification_emergency_ambulance,NotificationManagerHelper.GROUP_EMERGENCY, page);
		notificationHelper.triggerNotification(notification, NotificationManagerHelper.EMERGENCY);
		
		//service
		notification = notificationHelper.createNotification(R.drawable.ic_launcher,
				R.string.notification_service,
				R.string.notification_service_sanitary,NotificationManagerHelper.GROUP_SERVICE, null);
		notificationHelper.triggerNotification(notification, NotificationManagerHelper.SERVICE);
	}
}
