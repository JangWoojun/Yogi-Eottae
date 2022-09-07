package com.example.yogi_eottae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContaentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add( // items에 넣는다
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "태백산 생고기"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "태백산 생고기"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "태백산 생고기"
            )
        )



        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items) // RVAdapter 연결 baseContext랑 items를 보냄
        recyclerview.adapter = rvAdapter

        recyclerview.layoutManager = GridLayoutManager(this,2) // 두줄로 표시되게
    }
}