package net.vezk.contact_form.id

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.vezk.contact_form.data.ApiInterface
import net.vezk.contact_form.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun GetURL()=Constants.BASE_URL

    @Provides
    @Singleton
    fun RetrofitResponse(BASE_URL:String):ApiInterface=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
}