package com.lab.notifyme

import android.app.Application

class NotifyMeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NotificationChannelManager.createChannels(this)
    }
}