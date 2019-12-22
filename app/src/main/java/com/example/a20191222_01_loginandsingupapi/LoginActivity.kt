package com.example.a20191222_01_loginandsingupapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsingupapi.Utils.ConnectServer
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {


        loginBtn.setOnClickListener {
            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            ConnectServer.postRequestLogin(mContext,inputId,inputPw,object : ConnectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("로그인 응답",json.toString())

                    val code = json.getInt("code")

                    if (code == 200){

                    }
                    else{
                        val message = json.getString("message")
                        runOnUiThread {
                            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
                        }

                    }
                }

            })
        }


        signUpBtn.setOnClickListener {
            val intent = Intent(mContext,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun setValues() {

    }
}
