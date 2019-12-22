package com.example.a20191222_01_loginandsingupapi.Utils

import android.content.Context
import android.media.session.MediaSession

class ContextUtil {

    companion object{
        val prefName = "LoginPracticePreference"

        val USER_TOKEN = "USER_TOKEN"

        fun setUserToken(context: Context,token:String){
            val pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
            pref.edit().putString(USER_TOKEN,token).apply()
        }
        fun getUserToken(context: Context):String{
            val pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
            return USER_TOKEN
        }
    }
}