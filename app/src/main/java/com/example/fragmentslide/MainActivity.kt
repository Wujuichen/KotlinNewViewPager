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

    val person1 = User("Anne",  "女", 12345678,R.drawable.one)
    val person2 = User("Jason", "男", 20001125,R.drawable.two)
    val person3 = User("Joyce", "女", 20010816,R.drawable.three)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2 = findViewById(R.id.viewPager2)
        init(viewPager2)
        setUpTransformer(20,0.8f,0.2f)
    }

    private fun setUpTransformer(margin:Int, scale:Float,zoom:Float){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(20))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = scale + r * zoom
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun init(viewPager2: ViewPager2){

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
        /* (第49行)要先預覽左右各幾個頁面，避免使用者滑動到該頁面時無法呈現出來
           (第50行)clipToPadding:不要呈現邊界
           (第51行)clipToChildren:不要呈現兩邊的fragment
           (第52行)避免到最底頁的時候仍然呈現滑動效果
        * */
    }
}



