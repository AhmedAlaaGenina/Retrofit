package com.ahmedg.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmedg.retrofit.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}