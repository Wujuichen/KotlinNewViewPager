package com.example.fragmentslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ListAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var wordList : ArrayList<Int>
    //private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create fake person
        //val person1 = MyPerson("Anne",  1, 12345678)
        //val person2 = MyPerson("Jason", 0, 20001125)
        //val person3 = MyPerson("Joyce", 1, 20010816)

        //val personDetails = listOf(person1,person2,person3)

        // ... then create a list of people to insert into your adapter
    }
}