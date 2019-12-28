package com.example.binlist

import com.example.binlist.Model.Posts
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getNumbre(@Url url:String):Call<Posts.Numbre>

    @GET
    fun getBrand(@Url url:String):Call<Posts.brand>

    @GET
    fun getScheme(@Url url:String):Call<Posts.Scheme>


    companion object {
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://lookup.binlist.net/")
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

    }




}