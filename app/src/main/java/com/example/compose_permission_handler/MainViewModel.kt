package com.example.compose_permission_handler

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    val visiblePermissionDialogueQueue = mutableStateListOf<String>()


    fun dismissDialog(){
        visiblePermissionDialogueQueue.removeFirst()
    }

    fun onPermissionResult(
        permission:String,
        isGranted:Boolean
    ){
        if(!isGranted && !visiblePermissionDialogueQueue.contains(permission)){
            visiblePermissionDialogueQueue.add(permission)
        }
    }
}