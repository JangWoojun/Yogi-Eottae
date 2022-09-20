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
                "태백산 생고기"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=DbajPufRcAuf",
                "https://d12zq4w4guyljn.cloudfront.net/300_300_20220821040454_photo1_320a34ba8369.jpg",
                "원조두꺼비집불오징어"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=kGUj00swoxOY",
                "https://d12zq4w4guyljn.cloudfront.net/20210109221521_photo1_0UoOZNlTenDO.jpg",
                "갈현동할머니떡볶이"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=RKu1mJmKFu07",
                "https://d12zq4w4guyljn.cloudfront.net/20220815113148_photo1_b2e793a1d095.jpg",
                "화포식당"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=22HQH1t6RMxQ",
                "https://d12zq4w4guyljn.cloudfront.net/20210531100958352_photo_ad63db00f7d5.jpg",
                "꿀백"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=1Yq7wWcoo9lC",
                "https://d12zq4w4guyljn.cloudfront.net/20220222024859_photo1_8cb3442a10e0.jpg",
                "파술타"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=AihFEkc6mbvs",
                "https://d12zq4w4guyljn.cloudfront.net/20220626224908_photo1_FoyIWxPxct8g.jpg",
                "달가득치킨"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=RLAhrhB07H1h",
                "https://d12zq4w4guyljn.cloudfront.net/20220106090538_photo1_b4733a28d8cf.jpg",
                "유라쿠"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=o93Ns2yD7pVf",
                "https://d12zq4w4guyljn.cloudfront.net/20210916183929_photo1_pWpyRZAUvccH.jpg",
                "목노집"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=orfjE99gADGI",
                "https://d12zq4w4guyljn.cloudfront.net/20220112110559_photo1_26c47b4327c0.jpg",
                "H3 비스트로"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=wdNqgDFBth05",
                "https://d12zq4w4guyljn.cloudfront.net/20220101120217_photo1_93fea0d9f321.jpg",
                "낭풍"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=msymGJPTxLND",
                "https://d12zq4w4guyljn.cloudfront.net/20220920022352_photo1_b2e793a1d095.jpg",
                "에키소바"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=TEvcfTzIMWjR",
                "https://d12zq4w4guyljn.cloudfront.net/20220314050500_photo2_f68a0699b1ff.jpg",
                "라화방"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=eVzRQ81FaAZT",
                "https://d12zq4w4guyljn.cloudfront.net/20220617053548_photo1_65b79cfdbc80.jpg",
                "떡산"
            )
        )

        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=qX4cQC04i5IN",
                "https://d12zq4w4guyljn.cloudfront.net/20211024080847827_photo_85e922fd018d.jpg",
                "수유리우동집"
            )
        )
        items.add( //
            ContaentsModel(
                "https://www.diningcode.com/profile.php?rid=NBf337M1YCrb",
                "https://d12zq4w4guyljn.cloudfront.net/20210902104808_photo13_5d36a97a2160.jpg",
                "비보"
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
        


        recyclerview.layoutManager = GridLayoutManager(this,2) // 두줄로 표시되게
    }
}