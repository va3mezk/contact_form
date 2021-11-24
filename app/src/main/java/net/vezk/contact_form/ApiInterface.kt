package net.vezk.contact_form

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v3.1/all")
    fun getCountry() : Call<List<data>>
    companion object {
        var BASE_URL = "https://restcountries.com/v3.1/all/"
        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}