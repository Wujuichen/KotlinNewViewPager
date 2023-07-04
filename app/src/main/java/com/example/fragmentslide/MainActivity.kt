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
    private lateinit var adapter: MyPersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2 = findViewById(R.id.viewPager2)
        init(viewPager2)
        // 設置動畫效果
        setUpTransformer(20,0.8f)
        setViewPagerScroll(viewPager2)
    }

    private fun init(viewPager2: ViewPager2){
        //initPersonList()
        adapter = MyPersonAdapter(initPersonList() as ArrayList<User>) // 將 userList 作為MyPersonAdapter的參數傳遞給它
        adapter.submitList(initPersonList()) // 呈現userList的所有資料
        viewPager2.adapter = adapter
    }

    private fun initPersonList() : List<User> {
        val userList : MutableList<User> = ArrayList() // 創建一個新的list
        val person1 = User("Anne", "女", 12345678, R.drawable.one)
        val person2 = User("Jason", "男", 20001125, R.drawable.two)
        val person3 = User("Joyce", "女", 20010816, R.drawable.three)

        userList.add(person1) // 新增person1到userList
        userList.add(person2) // 新增person2到userList
        userList.add(person3) // 新增person3到userList

        return userList
    }

    private fun setUpTransformer(margin: Int, scale: Float){
        // margin:設定相鄰兩頁的間距
        // scale:設定左右兩頁的放大倍率(只能為0到1)
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(margin))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = scale + r * (1 - scale)  // 移動到主頁時或從別頁到主頁時，呈現視窗需要的大小
        }
        viewPager2.setPageTransformer(transformer) // 將setUpTransformer的參數設定顯現出來
    }

    private fun setViewPagerScroll(viewPager2: ViewPager2) {
        // 設置一頁三屏的效果
        viewPager2.offscreenPageLimit = 1  // 要先預覽左右各幾個頁面，避免使用者滑動到該頁面時無法呈現出來
        viewPager2.clipToPadding = false   // clipToPadding:不要呈現邊界
        viewPager2.clipChildren = false    // clipToChildren:不要呈現兩邊的fragment
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER // 避免在最首頁和最底頁的時候仍然呈現滑動效果
    }
}


