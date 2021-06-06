package com.dependencyinjection.edudev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {// addde all
    var datas: String ="pal G"
    lateinit var  testt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testt = findViewById<TextView>(R.id.maintest)
        testt?.setOnClickListener {
            testt.setText("Name is $datas")
        }
        
    }


}