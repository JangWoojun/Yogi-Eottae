package com.example.yogi_eottae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth // firebase에서 uid가져오기로 추정
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        if (auth.currentUser?.uid == null){
            Handler().postDelayed({
                startActivity(Intent(this,JoinActivity::class.java))
                finish()
            },3000)
        }
        else {
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },3000)
        }

        // 스플래쉬 화면을 메인 엑티비티에 넘겨준다 3초동안 보여주고


    }
}