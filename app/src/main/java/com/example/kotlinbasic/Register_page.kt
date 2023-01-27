package com.example.kotlinbasic


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class Register_page : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etUsername:EditText
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var etConfPassword:EditText
    lateinit var Confirm:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        etName = findViewById(R.id.etName)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etReg_Email)
        etPassword = findViewById(R.id.etReg_Password)
        etConfPassword = findViewById(R.id.etConf_Password)
        Confirm = findViewById(R.id.btnConfirm)

        Confirm.setOnClickListener {
            if (etName.text.toString().isNullOrEmpty()) {
                etName.error ="Enter Name"
            }
            else if (etUsername.text.toString().isNullOrEmpty()) {
                etUsername.error ="Enter Username"
            }
            else if (etEmail.text.toString().isNullOrEmpty()) {
                etEmail.error ="Enter Email"
            }
            else if (etPassword.text.toString().isNullOrEmpty()) {
                etPassword.error ="Enter Password"
            }
            else if(etConfPassword.text.toString().isNullOrEmpty()){
                etConfPassword.error = "Enter Confirm Password"
            }
            else if(etPassword.text.toString().length<6 || etPassword.text.toString().length>15){
                etPassword.error="Password must not be less than 6 characters and should not exceed 15 characters"
            }
            else if(etConfPassword.text.toString().length<6 || etConfPassword.text.toString().length>15){
                etConfPassword.error="Password must not be less than 6 characters and should not exceed 15 characters"
            }
            else if(etPassword.text.toString() != etConfPassword.text.toString()){

                etConfPassword.error = "Password doesn't match"
            }
            else{
                var intent = Intent(this@Register_page,After_Register::class.java)
                startActivity(intent)
            }
        }
    }
}