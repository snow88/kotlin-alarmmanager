package com.example.dell.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val i = Intent(this, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)                         //to make new task replace old task
        i.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)                    //to make new tasks launch over old tasks
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)             //to exclude (only new) tasks from recents
        val pi = PendingIntent.getActivity(this, 100, i, PendingIntent.FLAG_ONE_SHOT)

        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        am.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+ 1000 *10, 10*1000,
                pi)
    }
}
