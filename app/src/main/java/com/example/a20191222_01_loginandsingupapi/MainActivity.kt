package com.example.a20191222_01_loginandsingupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a20191222_01_loginandsingupapi.datas.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {


    }

    override fun setValues() {
        val user = intent.getSerializableExtra("user") as User

        userNameAndIdTxt.text = "${user.name}(${user.loginId})"
        userPhoneTxt.text = user.phoneNum

    }
}
