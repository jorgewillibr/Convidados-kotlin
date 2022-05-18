package com.jorgewilli.comvidados.service.repository.comsumer

import com.jorgewilli.comvidados.service.constants.RetrofitConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){

    companion object {
        private lateinit var retrofit: Retrofit

        fun getRetrofitInstance(): Retrofit{
            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(RetrofitConstants.BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <T>createService(serviceClass: Class<T>):T{
            return getRetrofitInstance().create(serviceClass)
        }

    }
}