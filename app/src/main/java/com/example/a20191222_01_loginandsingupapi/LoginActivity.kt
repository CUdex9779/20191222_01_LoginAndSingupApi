package com.example.a20191222_01_loginandsingupapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsingupapi.Utils.ConnectServer
import com.example.a20191222_01_loginandsingupapi.datas.User
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

                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")


                        val userData = User.getUserDataFromJson(user)

                        val intent = Intent(mContext,MainActivity::class.java)
                        intent.putExtra("name",userData.name)
                        intent.putExtra("id",userData.loginId)
                        intent.putExtra("phone",userData.phoneNum)
                        startActivity(intent)
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
