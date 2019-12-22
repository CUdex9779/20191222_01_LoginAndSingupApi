package com.example.a20191222_01_loginandsingupapi.datas

import android.icu.text.CaseMap
import java.io.Serializable

class BlackListData(phone:String,title: String,content:String):Serializable {

    var phoneNum = phone
    var title = title
    var content = content
}