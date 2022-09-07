package com.example.yogi_eottae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 스플래쉬 화면을 메인 엑티비티에 넘겨준다 3초동안 보여주고
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        },3000)

    }
}