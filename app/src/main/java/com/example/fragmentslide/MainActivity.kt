package com.example.fragmentslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: MyPersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setUpTransformer()
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(20))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.8f + r * 0.2f
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun init(){

        viewPager2 = findViewById(R.id.viewPager2)

        val person1 = User("Anne",  "女", 12345678)
        val person2 = User("Jason", "男", 20001125)
        val person3 = User("Joyce", "女", 20010816)

        userList = ArrayList()
        userList.add(person1)
        userList.add(person2)
        userList.add(person3)

        adapter = MyPersonAdapter(userList)
        adapter.submitList(userList)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 1
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
}

        //val myPersonList = mutableListOf(person1, person2, person3)

        //val listadapter = MyPerson(myPersonList)
        //listadapter.submitList(null)

        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.adapter = listadapter

        //listadapter.submitList(myPersonList)


    //private fun generateFragments(userList: List<User>): MutableList<Fragment> {
    //    val fragments = mutableListOf<Fragment>()

    //    for (user in userList) {
    //        val fragment = MyPerson.newInstance(user)
    //        fragments.add(fragment)
    //    }

    //    return fragments
    //}

        // create fake person
        //val person1 = MyPerson("Anne",  1, 12345678)
        //val person2 = MyPerson("Jason", 0, 20001125)
        //val person3 = MyPerson("Joyce", 1, 20010816)

        //val personDetails = listOf(person1,person2,person3)

        // ... then create a list of people to insert into your adapter

//val userList = mutableListOf(
//   User("Anne", 1, 12345678),
//   User("Jason", 0, 20001125),
//   User("Joyce", 1, 20010816)
//)


