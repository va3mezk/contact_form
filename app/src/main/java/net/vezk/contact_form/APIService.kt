package net.vezk.contact_form

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCountry(@Url url:String): Response<dataCountry>
}