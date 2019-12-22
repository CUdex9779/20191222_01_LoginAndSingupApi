package com.example.a20191222_01_loginandsingupapi

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {


        signUpBtn.setOnClickListener {
            val intent = Intent(mContext,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun setValues() {

    }
}
