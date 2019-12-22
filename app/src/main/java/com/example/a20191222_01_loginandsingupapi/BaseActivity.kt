package com.example.a20191222_01_loginandsingupapi

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setEvents()
    abstract fun setValues()

}