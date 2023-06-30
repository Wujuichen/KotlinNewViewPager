package com.example.fragmentslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var userList: ArrayList<String>
    private lateinit var adapter: MyPersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager2)

        val person1 = User("Anne",  1, 12345678)
        val person2 = User("Jason", 0, 20001125)
        val person3 = User("Joyce", 1, 20010816)

        userList = ArrayList()
        userList.add(person1.toString())
        userList.add(person2.toString())
        userList.add(person3.toString())

        adapter = MyPersonAdapter(userList,viewPager2)
        viewPager2.adapter = adapter

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


