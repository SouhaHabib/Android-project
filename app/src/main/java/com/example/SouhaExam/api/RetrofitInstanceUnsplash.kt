package com.example.SouhaExam.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceUnsplash {

    companion object {
        private val BASE_URL = "https://api.unsplash.com/"

        val interceptor: HttpLoggingInterceptor =HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(RetrofitInstanceUnsplash.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        fun buildService(): RestInterface{
            return getRetrofitInstance().create(RestInterface::class.java);
        }
    }


}