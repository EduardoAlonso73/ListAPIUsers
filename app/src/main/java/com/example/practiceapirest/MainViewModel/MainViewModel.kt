package com.example.practiceapirest.MainViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiceapirest.Model.User

class MainViewModel:ViewModel() {
    private  var interact=MainInteract()
    private  val userLis:MutableLiveData<MutableList<User>> by
    lazy {MutableLiveData<MutableList<User>>().also {loadUserLisr()  }  }



    private fun loadUserLisr() {
        interact.getUserList {userList->
            userLis.value=userList
        }
    }

    /*-=-=-=-=-=-=-=-=-=-=-==-=-=-=--=-=-=-=-=-=-=-==
               ---Function to call in the View -----
    =-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-==-=-=-=--=-=-*/
    fun getAllUser():LiveData<MutableList<User>> = userLis
}