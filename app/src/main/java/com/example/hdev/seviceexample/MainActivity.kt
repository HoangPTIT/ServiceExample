package com.example.hdev.seviceexample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG : String = "MAIN"
    private var btn_start: Button? = null
    private var btn_stop: Button? = null
    val conn = AppServiceConnection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
    }

    private fun initView() {
        btn_start = findViewById(R.id.btn_start)
        btn_stop = findViewById(R.id.btn_stop)

        btn_start?.setOnClickListener(this)
        btn_stop?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(baseContext, AppService::class.java)
        if (v == null) return
        when (v.id) {
            R.id.btn_start -> {
//                startService(intent)
                bindService(intent, conn, Context.BIND_AUTO_CREATE) // BoundService
            }

            R.id.btn_stop -> {
//                stopService(Intent(baseContext, AppService::class.java))
                unbindService(conn)
            }
        }
    }

    inner class AppServiceConnection : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG, "onServiceConnected")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected")
        }

    }
}
