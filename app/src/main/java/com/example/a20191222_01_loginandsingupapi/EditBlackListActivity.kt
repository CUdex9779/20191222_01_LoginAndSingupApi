package com.example.a20191222_01_loginandsingupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_black_list.*

class EditBlackListActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_black_list)

        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {

        postBtn.setOnClickListener {

            val title = titleEdt.text.toString()
            val phone = phoneNumEdt.text.toString()
            val content = contentEdt.text.toString()

//            서버에 게시글 등록을 요청하는 기능을 추가해야함

        }

    }

    override fun setValues() {

    }
}
