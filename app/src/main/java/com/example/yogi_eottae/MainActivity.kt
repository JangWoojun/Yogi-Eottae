package com.example.yogi_eottae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContaentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn) // 북마크 버튼을 클릭하면
        bookmarkButton.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent) // BookmarkActivity로 이동
       }

        items.add( // items에 넣는다
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "다이닝 코드"
            )
        )
        items.add( //
            ContaentsModel(
                    "https://www.siksinhot.com/P/254616",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "식신"
            )
        )
        items.add( // items에 넣는다
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "다이닝 코드"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.siksinhot.com/P/254616",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "식신"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.siksinhot.com/P/254616",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "식신"
            )
        )
        items.add( // items에 넣는다
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "다이닝 코드"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.siksinhot.com/P/254616",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "식신"
            )
        )
        items.add( // items에 넣는다
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1c1uOUTGZopQ",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "다이닝 코드"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.siksinhot.com/P/254616",
                "https://d12zq4w4guyljn.cloudfront.net/20220601122546_photo1_93fea0d9f321.jpg",
                "식신"
            )
        )


        val Logout = findViewById<TextView>(R.id.logout)
        Logout.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent) // JoinActivity로 이동
        }

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items) // RVAdapter 연결 baseContext랑 items를 보냄
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext,VIewActivity::class.java)
                intent.putExtra("url",items[position].url)// url을 담아보내겠다
                intent.putExtra("title",items[position].titleText)// titleText을 담아보내겠다
                intent.putExtra("imgUrl",items[position].imageUrl)// imageUrl을 담아보내겠다
                startActivity(intent)
            }

        }

        recyclerview.layoutManager = GridLayoutManager(this,1) // 두줄로 표시되게
    }
}