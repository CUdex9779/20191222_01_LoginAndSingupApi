package com.example.a20191222_01_loginandsingupapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsingupapi.Utils.ConnectServer
import kotlinx.android.synthetic.main.activity_sign_up.*

import org.json.JSONObject

class SignUpActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {


        signUpBtn.setOnClickListener {
            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()
            val inputName = nameEdt.text.toString()
            val inputPhone = phoneEdt.text.toString()

            ConnectServer.putRequestSignUp(mContext,inputId,inputPw,inputName,inputPhone,object :ConnectServer.JsonResponseHandler{
                override fun onResponse(json:JSONObject) {

                    Log.d("회원가입 응답", json.toString())

                    val code = json.getInt("code")
                    Log.d("회원가입 코드", "${code}")
                    val message = json.getString("message")





                    runOnUiThread {

                        Toast.makeText(mContext, message , Toast.LENGTH_SHORT).show()

                        if (code == 200) {

                            finish()
                        }


                    }

                }
            })
        }
    }

    override fun setValues() {

    }
}
