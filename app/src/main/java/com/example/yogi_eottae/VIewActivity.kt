package com.example.yogi_eottae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class  VIewActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth // 회원가입 로그인 기능 사용
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth

        val webView = findViewById<WebView>(R.id.webview)
        webView.apply {
            webViewClient = WebViewClient() // 페이지 컨트롤을 위한 기본적인 함수, 다양한 요청, 알림을 수신하는 기능
            settings.javaScriptEnabled = true // 자바스크립트 허용
            webViewClient = WebViewClient() // 하이퍼링크 클릭시 새창 띄우기 방지
        }

        webView.loadUrl(intent.getStringExtra("url").toString()) // load한다 intent에 있는 url이란 값을

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imgUrl = intent.getStringExtra("imgUrl").toString()

        val saveText = findViewById<TextView>(R.id.save) // id save 버튼을 누르면
        saveText.setOnClickListener {
            Toast.makeText(this,"찜 하셨습니다", Toast.LENGTH_LONG).show()
            myBookmarkRef
                .child(auth.currentUser!!.uid) //현재 유저의 uid값으로 저장한다
                .push()
                .setValue(ContaentsModel(url,imgUrl,title)) // ContaentsModel에 있는 url,imgUrl,title을 저장
        }



    }
}
