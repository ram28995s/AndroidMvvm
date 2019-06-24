package com.example.myapplication

import android.app.Application

class MainViewModel(application: Application):BaseViewModel<Any>(application) {

    var data:String?=null

    companion object {
        fun getInstance(application: Application):MainViewModel{
            return MainViewModel(application)
        }
    }

    fun set(){
        data="fsdfs"
    }
}