package com.luser.android.wear.notification;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preview.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

/**
 * Provides and manages notifications
 * 
 * @author kocyigitre
 *
 */
@SuppressLint("ServiceCast")
public class NotificationManagerHelper {

	public static final String TAG = NotificationManagerHelper.class.getSimpleName();
	public static final int RESULT_CODE_NOTIFICATION = 0;
	
	public static final int SERVICE = 0;
	public static final int CONTACT = 1;
	public static final int CONTACT_FAMILY = 2;
	public static final int EMERGENCY = 3;
	
	public static final String GROUP_SERVICE = "service";
	public static final String GROUP_CONTACT = "contact";
	public static final String GROUP_EMERGENCY = "emergency";
	
	private Intent resultIntent;
	private NotificationManagerCompat notificationManager;
	private PendingIntent resultPendingIntent;
	private Context context;
	
	/**
	 * 
	 * @param clzz for pending intent, resulting back to calling activity
	 * @param context to retrieve resources
	 */
	public NotificationManagerHelper(Class clzz, Context context){
		
		if(context == null){
			throw new IllegalArgumentException();
		}
		
		this.context = context;
		resultIntent = new Intent(context, clzz);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		stackBuilder.addParentStack(clzz);
		stackBuilder.addNextIntent(resultIntent);
		resultPendingIntent = stackBuilder.getPendingIntent(RESULT_CODE_NOTIFICATION, PendingIntent.FLAG_UPDATE_CURRENT);
		notificationManager = NotificationManagerCompat.from(context);
	}
	
	public void createNotification(int notificationIcon, int resIdtitle, int resIdContentText, String groupKey){
		NotificationCompat.Builder notificationBuilder =
		        new NotificationCompat.Builder(context)
		        .setSmallIcon(notificationIcon)
		        .setContentTitle(context.getString(resIdtitle))
		        .setVibrate(new long[]{500})
		        .setContentIntent(resultPendingIntent)
		        .setOngoing(true)
		        .setContentText(context.getString(resIdContentText));
		
//		WearableNotifications.Builder featureBuilder = new WearableNotifications.Builder(notificationBuilder);
//		featureBuilder.setGroup(groupKey);
//		if(page != null){
//			featureBuilder.addPage(page);
//		}

		switch(groupKey){
		case NotificationManagerHelper.GROUP_CONTACT:
			notificationManager.notify(NotificationManagerHelper.CONTACT, notificationBuilder.build());			
			break;
		case NotificationManagerHelper.GROUP_EMERGENCY:
			notificationManager.notify(NotificationManagerHelper.EMERGENCY, notificationBuilder.build());			
			break;
		case NotificationManagerHelper.GROUP_SERVICE:
			notificationManager.notify(NotificationManagerHelper.SERVICE, notificationBuilder.build());			
			break;
		}

	}
	
	public void cancelNotification(int id){
		if(notificationManager != null){
			notificationManager.cancel(id);			
		}
	}
}
