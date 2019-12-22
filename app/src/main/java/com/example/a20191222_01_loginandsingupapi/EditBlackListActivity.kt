package com.example.a20191222_01_loginandsingupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a20191222_01_loginandsingupapi.Utils.ConnectServer
import kotlinx.android.synthetic.main.activity_edit_black_list.*
import org.json.JSONObject

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

//            서버에 등록 API를 호출하는 코드
            ConnectServer.postRequestBlackList(mContext,title,phone,content,object : ConnectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {

                    Log.d("게시글등록응답",json.toString())

                }

            })

        }

    }

    override fun setValues() {

    }
}
