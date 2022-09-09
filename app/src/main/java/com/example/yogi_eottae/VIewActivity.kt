package com.example.yogi_eottae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class  VIewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)


        val webView = findViewById<WebView>(R.id.webview)
        webView.apply {
            webViewClient = WebViewClient() // 페이지 컨트롤을 위한 기본적인 함수, 다양한 요청, 알림을 수신하는 기능
            settings.javaScriptEnabled = true // 자바스크립트 허용
            webViewClient = WebViewClient() // 하이퍼링크 클릭시 새창 띄우기 방지
        }

        webView.loadUrl(intent.getStringExtra("url").toString())
    }
}
