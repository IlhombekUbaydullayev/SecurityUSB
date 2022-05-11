package com.example.security_debugging_part2_inkotlin

import android.widget.Toast

import android.os.BatteryManager

import android.content.Intent

import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log


object PowerConnectionReceiver
    : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("charging", "NOOOO")
        if (Intent.ACTION_POWER_CONNECTED == intent.action) {
            val messageb = "broadCast!!!"
            Toast.makeText(context, messageb, Toast.LENGTH_LONG)
        }
        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        val isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING
                || status == BatteryManager.BATTERY_STATUS_FULL)
        if (isCharging) {
            val message = "yes"
            Toast.makeText(context, "onReceive! $message", Toast.LENGTH_LONG).show()
            Log.d("charging", "YES")
            intent.setClass(context, MainActivity::class.java)
            context.startActivity(intent)
        } else {
            val message = "no"
            Toast.makeText(context, "onReceive! $message", Toast.LENGTH_LONG).show()
            Log.d("charging", "YES")
        }
    }
}