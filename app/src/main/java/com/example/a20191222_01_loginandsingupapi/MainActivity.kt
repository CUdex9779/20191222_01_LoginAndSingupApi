package com.example.a20191222_01_loginandsingupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsingupapi.Utils.ConnectServer
import com.example.a20191222_01_loginandsingupapi.datas.BlackListData
import com.example.a20191222_01_loginandsingupapi.datas.User
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    val blackList = ArrayList<BlackListData>()


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


        getBlackListsFromServer()
    }

    fun getBlackListsFromServer(){

        ConnectServer.getRequestBlackList(mContext,object : ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("블랙리스트목록응답",json.toString())

                val code = json.getInt("code")
                if (code == 200){

                    val data = json.getJSONObject("data")
                    val black_lists = data.getJSONArray("black_lists")

                    for (i in 0..black_lists.length()-1){



                        blackList.add(BlackListData.getBlackListDataFromJson(black_lists.getJSONObject(i)))

                    }
                }
                else{
                    val message = json.getString("message")
                    runOnUiThread{
                        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

    }
}
