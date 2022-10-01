package com.example.practiceapirest.Model.common

import android.app.Application

class UserApplication : Application() {
    companion object{
        lateinit var reqResAPI: ReqResAPI
    }
    override fun onCreate() {
        super.onCreate()
        //Volley
        reqResAPI = ReqResAPI.getInstance(this)
    }
}