package com.example.hdev.seviceexample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class PlaySongService : Service() {
    /*
    * Moi phat va phat lai
    * Lam sao de phat tiep tu luc dung*/
    private val TAG = "PLAYSONG"
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.thangdien)
    }

    override fun onBind(intent: Intent): IBinder? {
        TODO("Return the communication channel to the service.")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("PLAYSONG", "Start song")
        mediaPlayer?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        mediaPlayer?.release()
        super.onDestroy()
    }
}
