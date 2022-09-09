package com.example.yogi_eottae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth

        val email = findViewById<EditText>(R.id.emailArea)
        val password = findViewById<EditText>(R.id.passwordArea)

        val joinBtn = findViewById<Button>(R.id.joinBtn)
        joinBtn.setOnClickListener {


            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 회원가입 성공시 main으로
                        Toast.makeText(this,"회원가입 성공", Toast.LENGTH_LONG).show()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // 회원가입 실패시 Log 출력
                        Log.w("JoinActivity", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(this,"회원가입 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }

        val loginBtn = findViewById<Button>(R.id.LoginBtn)
        loginBtn.setOnClickListener {

            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"로그인 성공", Toast.LENGTH_LONG).show()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }


    }
}