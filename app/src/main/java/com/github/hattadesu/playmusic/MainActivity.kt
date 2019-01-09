package com.github.hattadesu.playmusic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.content.Intent
import android.os.Handler
import android.provider.MediaStore

class MainActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.button_play) as Button
        button.setOnClickListener {
            Toast.makeText(this@MainActivity, "Tapped", Toast.LENGTH_LONG).show()
            val intent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_MUSIC);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Min SDK 15
            startActivity(intent);
/*
            val intent2 = Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH)
            intent2.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, "vnd.android.cursor.item/audio")
            startActivity(intent2);
*/
            handler.postDelayed({
                val intent3 = Intent("com.android.music.musicservicecommand")
                intent3.putExtra("command", "play")
                sendBroadcast(intent3)
                Toast.makeText(this@MainActivity, "Triggered", Toast.LENGTH_LONG).show()
            }, 5000)
        }
    }
}
