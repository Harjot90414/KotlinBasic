package com.example.kotlinbasic


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var btnRegister:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener{
            if(etEmail.text.toString().isNullOrEmpty()){
                etEmail.error="Enter Email"
            }
            else if(etPassword.text.toString().isNullOrEmpty()){
                etPassword.error="Enter password"
            }
            else if(etPassword.text.toString().length<6 || etPassword.text.toString().length>15){
                etPassword.error="Password must not be less than 6 characters and should not exceed 15 characters"
            }
            else{
             var intent = Intent(this@MainActivity ,After_login::class.java)
                startActivity(intent)
            }
        }

        btnRegister.setOnClickListener{
            val intent = Intent(this@MainActivity,Register_page::class.java)
            startActivity(intent)
        }
    }
}