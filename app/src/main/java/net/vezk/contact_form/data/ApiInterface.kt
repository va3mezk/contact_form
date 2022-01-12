@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection"
)

package net.vezk.contact_form.data

import net.vezk.contact_form.utils.Constants
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * 🇪🇸
 * Creación del servicio Retrofit https://restcountries.com/v3.1/all/ de donde
 * consumiremos el nombre de los paises del mundo
 *
 * 🇺🇸
 ** Creation of the Retrofit service https://restcountries.com/v3.1/all/ from where
 * we will consume the name of the countries of the world
 **/
interface ApiInterface {
    @GET(Constants.END_POINT)
    suspend fun GetCountry():Response<CountryResponse>
}