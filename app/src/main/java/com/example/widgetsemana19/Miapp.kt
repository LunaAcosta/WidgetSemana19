package com.example.widgetsemana19

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class Miapp : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {

    // Codigo para mostrar la actividad al presionar el boton notas en el Widgets
    val i1 : PendingIntent = Intent(context,Notas::class.java).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)  }

   // Codigo para mostrar la actividad al presionar el boton canvas en el Widgets
    val i2 : PendingIntent = Intent(context,Canvas::class.java).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)  }



//
    val views = RemoteViews(context.packageName, R.layout.miapp)
        //  funcion de evento onclicck para el primer boton
        .apply{setOnClickPendingIntent(R.id.btnNotas,i1)}
        //  funcion de evento onclicck para el segundo boton
        .apply { setOnClickPendingIntent(R.id.btnCanvas,i2) }


    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)

}