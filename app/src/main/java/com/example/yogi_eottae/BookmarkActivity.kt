package com.example.yogi_eottae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private  val contaentsModels = mutableListOf<ContaentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        auth = Firebase.auth

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref") // 리얼타임데이터베이스 사용

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,contaentsModels) // RVAdapter 연결 baseContext랑 contaentsModelsdm을 보냄
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext,VIewActivity::class.java)
                intent.putExtra("url",contaentsModels[position].url)// url을 담아보내겠다
                intent.putExtra("title",contaentsModels[position].titleText)// titleText을 담아보내겠다
                intent.putExtra("imgUrl",contaentsModels[position].imageUrl)// imageUrl을 담아보내겠다
                startActivity(intent)
            }

        }
        recyclerview.layoutManager = GridLayoutManager(this,2) // 두줄로 표시되게

        myBookmarkRef
            .child(auth.currentUser?.uid.toString()) //uid를 가져와서
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataModel in snapshot.children){

                        contaentsModels.add(dataModel.getValue(ContaentsModel::class.java)!!)
                        //위에 생성한 contaentsModels에 dataModel에 값을 ContaentsModel 형태로 넣는다

                    }
                    rvAdapter.notifyDataSetChanged() // 웨 for문이 끝나면 rvAdpter 작업 진행
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark","dbError") // 실패 경우
                }

            })



    }
}