@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection")

package net.vezk.contact_form.domain

import androidx.lifecycle.*
import net.vezk.contact_form.data.Data
import retrofit2.*

/**
 *🇪🇸
 * En la configuración de ViewModel[MainViewModel], necesitamos crear una clase y extender ViewModel.
 * La clase ViewModel[MainViewModel] que tiene la lógica de negocios y las implementaciones
 * de llamadas a la API.
 * En el constructor ViewModel[MainViewModel], necesitamos pasar el repositorio de datos para manejar los datos.
 *
 * 🇺🇸
 ** In ViewModel[MainViewModel] configuration , we need to create a class and extend ViewModel.
 * The ViewModel [MainViewModel] class that has the business logic and implementations
 * API calls.
 * In the ViewModel [MainViewModel] constructor, we need to pass the data repository to handle the data.
 *
 **/
class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val countryList = MutableLiveData<List<String>>()

    fun getCountry() {
        val response = repository.getCountry()
        response.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                val originalList: List<Data> = response.body()!!
                val newList: List<String> = originalList
                    .sortedBy { it.name.common }
                    .map { it.name.common }
                newList.sorted()
                countryList.postValue(newList)
            }
            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}