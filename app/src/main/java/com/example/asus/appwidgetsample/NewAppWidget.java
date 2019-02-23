package com.example.asus.appwidgetsample;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RemoteViews;

import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        Calendar calendar = Calendar.getInstance();
        int thisDay;
        CharSequence tarih="..";
        CharSequence yemek_listesi_text="..";
        thisDay = calendar.get(Calendar.DAY_OF_MONTH);
        if(thisDay==22)
        {
             tarih ="22.02.2019";
             yemek_listesi_text =context.getString(R.string.yemek_22);
        }
        if(thisDay==25)
        {
             tarih ="25.02.2019";
             yemek_listesi_text =context.getString(R.string.yemek_25);
        }
        if(thisDay==26)
        {
             tarih ="26.02.2019";
             yemek_listesi_text =context.getString(R.string.yemek_26);
        }
        if(thisDay==27)
        {
             tarih ="27.02.2019";
             yemek_listesi_text =context.getString(R.string.yemek_27);
        }
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.tarih,tarih);
        views.setTextViewText(R.id.yemek_listesi,yemek_listesi_text);

        Intent intentUpdate = new Intent(context, NewAppWidget.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] idArray = new int[]{appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
        PendingIntent pendingUpdate = PendingIntent.getBroadcast(context,
                appWidgetId, intentUpdate, PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.guncelle, pendingUpdate);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }


}

