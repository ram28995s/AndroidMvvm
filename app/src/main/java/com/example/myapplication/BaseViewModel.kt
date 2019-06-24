package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel<N>(application: Application):AndroidViewModel(application) {

    private var navigator:N? = null

    protected fun getNavigator():N? = navigator

    protected fun setNavigator(navigator:N){
        this.navigator=navigator
    }

    /*fun getBswApi(application: Application): ApiBSW {
        return ApiCall.getApiCall(application).getBswApi()
    }*/
}