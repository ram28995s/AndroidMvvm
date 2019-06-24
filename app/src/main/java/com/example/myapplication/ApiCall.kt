package com.example.myapplication

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit





class ApiCall {

    private var httpClient: OkHttpClient? = null

    constructor(application: Application){
        buildClient(application)
    }


    companion object {
        lateinit var mApiCall : ApiCall

        fun getApiCall(application: Application):ApiCall{
            if(mApiCall==null){
                mApiCall= ApiCall(application)
            }
            return mApiCall
        }
    }

    fun buildClient(application: Application){
        val builder = OkHttpClient.Builder()
        httpClient = builder.build();
    }

    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*fun getBswApi(): ApiBSW {
        if (mApiBSW == null) {
            mApiBSW = getRetrofit(Urls.getBswUrl()).create(ApiBSW::class.java)
        }
        return mApiBSW
    }*/

}