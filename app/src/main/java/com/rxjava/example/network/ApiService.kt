package com.rxjava.example.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("/test/profile.php")
    fun getProfile(): Observable<String>

    companion object Factory {
        fun create(): ApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl("http://firdaus91.web.id/")
            return retrofit.build().create(ApiService::class.java)
        }
    }
}