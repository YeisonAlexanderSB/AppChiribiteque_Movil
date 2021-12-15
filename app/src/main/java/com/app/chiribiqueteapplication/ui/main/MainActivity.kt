package com.app.chiribiqueteapplication.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.app.chiribiqueteapplication.R
import com.app.chiribiqueteapplication.ui.activitys.FragmentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonaventuras=findViewById<Button>(R.id.adventure_button)
        botonaventuras.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }


}