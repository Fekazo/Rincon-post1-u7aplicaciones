package com.lab.notifyme

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build

object NotificationChannelManager {
    const val CHANNEL_GENERAL = "channel_general"
    const val CHANNEL_URGENT = "channel_urgent"
    const val CHANNEL_SILENT = "channel_silent"

    fun createChannels(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        val manager = context.getSystemService(NotificationManager::class.java)

        val channelGeneral = NotificationChannel(
            CHANNEL_GENERAL,
            "Notificaciones Generales",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Avisos del curso y recordatorios"
            enableVibration(true)
        }

        val channelUrgent = NotificationChannel(
            CHANNEL_URGENT,
            "Alertas Urgentes",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Entregas próximas y fechas límite"
            enableLights(true)
            lightColor = Color.RED
        }

        val channelSilent = NotificationChannel(
            CHANNEL_SILENT,
            "Sincronización Silenciosa",
            NotificationManager.IMPORTANCE_MIN
        ).apply {
            description = "Actualizaciones de datos en segundo plano"
            setShowBadge(false)
        }

        manager.createNotificationChannels(
            listOf(channelGeneral, channelUrgent, channelSilent)
        )
    }
}