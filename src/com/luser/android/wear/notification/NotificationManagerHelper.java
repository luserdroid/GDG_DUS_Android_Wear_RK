package com.luser.android.wear.notification;

import com.luser.android.wear.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class NotificationManagerHelper {

	public static final String TAG = NotificationManagerHelper.class.getSimpleName();
	public static final int RESULT_CODE_NOTIFICATION = 0;
	private Intent resultIntent;
	private NotificationManager notificationManager;
	private Notification notification;
	private PendingIntent resultPendingIntent;
	private Context context;
	public NotificationManagerHelper(Class clzz, Context context){
		this.context = context;
		resultIntent = new Intent(context, clzz);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		stackBuilder.addParentStack(clzz);
		stackBuilder.addNextIntent(resultIntent);
		resultPendingIntent = stackBuilder.getPendingIntent(RESULT_CODE_NOTIFICATION, PendingIntent.FLAG_UPDATE_CURRENT);
		notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	public void createNotification(int notificationIcon, String title, String contentText, String tag, int id){
		NotificationCompat.Builder notificationBuilder =
		        new NotificationCompat.Builder(context)
		        .setSmallIcon(notificationIcon)
		        .setContentTitle(title)
		        .setVibrate(new long[]{500})
		        .setContentIntent(resultPendingIntent)
		        .setOngoing(true)
		        .setContentText(contentText);
		notification = notificationBuilder.build();
		notificationManager.notify(tag, id, notification);
	}
}
