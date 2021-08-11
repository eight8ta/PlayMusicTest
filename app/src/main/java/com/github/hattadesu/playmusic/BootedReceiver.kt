package com.github.hattadesu.playmusic

import android.bluetooth.BluetoothAdapter
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
//import sun.invoke.util.VerifyAccess.getPackageName
import android.content.BroadcastReceiver
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.IntentFilter
import android.widget.Toast

class BootedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent != null) {
            var execute = false
            if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
                Toast.makeText(context, "Booted", Toast.LENGTH_LONG).show()
                execute = true
            } else if (Intent.ACTION_PACKAGE_REPLACED == intent.action && intent.dataString!!.contains(context.getPackageName())) {
                Toast.makeText(context, "Package Replaced", Toast.LENGTH_LONG).show()
                execute = true
            }
            if (execute) {
                val filter = IntentFilter()
                filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED)
                context.registerReceiver(btReceiver, filter)
            }
        }
    }
    private val btReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            when (intent?.action) {
                BluetoothDevice.ACTION_ACL_CONNECTED -> handleConnected(context, intent)
            }
        }
    };
    fun handleConnected(context: Context, intent: Intent?) {
        Toast.makeText(context, "Connected", Toast.LENGTH_LONG).show()
    }
}
