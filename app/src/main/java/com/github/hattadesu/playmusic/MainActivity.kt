package com.github.hattadesu.playmusic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.content.Intent
import android.provider.MediaStore



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.button_play) as Button
        button.setOnClickListener {
            //Toast.makeText(this@MainActivity, "Tapped", Toast.LENGTH_LONG).show()
            val intent = Intent("com.android.music.musicservicecommand")
            intent.putExtra("command", "play")
            sendBroadcast(intent)
        }
    }
}
