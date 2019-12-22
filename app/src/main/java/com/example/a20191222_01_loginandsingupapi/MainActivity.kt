package com.example.a20191222_01_loginandsingupapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsingupapi.Utils.ConnectServer
import com.example.a20191222_01_loginandsingupapi.adapters.BlackListAdapter
import com.example.a20191222_01_loginandsingupapi.datas.BlackListData
import com.example.a20191222_01_loginandsingupapi.datas.User
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {


    val blackList = ArrayList<BlackListData>()
    var blackListDataAdapter:BlackListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {

        postBlackListBtn.setOnClickListener {
            val intent = Intent(mContext,EditBlackListActivity::class.java)
            startActivity(intent)
        }


    }

    override fun setValues() {

        val user = intent.getSerializableExtra("user") as User
        userNameAndIdTxt.text = "${user.name}(${user.loginId})"
        userPhoneTxt.text = user.phoneNum

        getBlackListsFromServer()

        blackListDataAdapter = BlackListAdapter(mContext,R.layout.black_list_item,blackList)
        blackListView.adapter = blackListDataAdapter
    }

    fun getBlackListsFromServer(){

        ConnectServer.getRequestBlackList(mContext,object : ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {


                val code = json.getInt("code")
                if (code == 200){

                    val data = json.getJSONObject("data")
                    val black_lists = data.getJSONArray("black_lists")

                    for (i in 0..black_lists.length()-1){



                        blackList.add(BlackListData.getBlackListDataFromJson(black_lists.getJSONObject(i)))

                    }

                    runOnUiThread{
                        blackListDataAdapter?.notifyDataSetChanged()
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
