package com.sikdev.lesson_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class Launch_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)

        var timer: Timer = Timer();
        var tick: Int = 0;
        timer.schedule(object : TimerTask() {
            override fun run() {
                tick++
                Log.d("Tick", tick.toString())
                if (tick > 2) {
                    runOnUiThread {
                        var sharedPreferences = getSharedPreferences("SaveSettings", Context.MODE_PRIVATE)
                        if(sharedPreferences.getBoolean("launch", false))
                        {
                            // Не первый запуск приложения
                            val intent = Intent(this@Launch_Screen, SingUp_Screen::class.java)
                            startActivity(intent)
                        }
                        else
                        {
                            // Первый запуск приложения
                            val sharedPreferencesEditor = sharedPreferences.edit()
                            sharedPreferencesEditor.putBoolean("launch", true).apply()
                            val intent = Intent(this@Launch_Screen, SignIn_Screen::class.java)
                            startActivity(intent)
                        }
                        timer.cancel()
                    }
                }
            }
        }, 0, 1000)
    }
}