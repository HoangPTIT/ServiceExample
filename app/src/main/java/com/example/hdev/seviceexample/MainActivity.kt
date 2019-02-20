package com.example.hdev.seviceexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btn_start : Button? = null
    private var btn_stop : Button? = null

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
        if (v == null) return
        when(v.id){
            R.id.btn_start -> {
                startService(Intent(baseContext, MyService::class.java))
            }

            R.id.btn_stop -> {
                stopService(Intent(baseContext, MyService::class.java))
            }
        }
    }
}
