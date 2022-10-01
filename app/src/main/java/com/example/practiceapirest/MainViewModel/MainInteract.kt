package com.example.practiceapirest.MainViewModel

import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.practiceapirest.Model.User
import com.example.practiceapirest.Model.common.Constants
import com.example.practiceapirest.Model.common.UserApplication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainInteract {


    fun  getUserList(callback: (MutableList<User>)->Unit){
        var userList: MutableList<User>
        val url=Constants.USER_URL+Constants.GET_ALL_PATH
        val jsonObjectRequest=JsonObjectRequest(Request.Method.GET,url,null,{ res->
            val jsonList=res.optJSONArray(Constants.STORES_PROPERTY)?.toString()
            Log.i("JSON_LIST",jsonList.toString())
            jsonList?.let {
                val mutableListType=object:TypeToken<MutableList<User>>(){}.type
                userList=Gson().fromJson(it,mutableListType)
                Log.i("RESULT",userList.toString())
                callback(userList)
                return@JsonObjectRequest
            }
        },{
            it.printStackTrace()
        })
        UserApplication.reqResAPI.addToRequestQueue(jsonObjectRequest)
    }

}