package com.example.fragmentslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create fake person
        val person1 = MyPerson("Anne", 1, 12345678)

        // ... then create a list of people to insert into your adapter
    }
}