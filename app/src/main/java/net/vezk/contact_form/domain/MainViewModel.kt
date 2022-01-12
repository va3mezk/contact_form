@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection")

package net.vezk.contact_form.domain

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.vezk.contact_form.data.Data
import retrofit2.*
import javax.inject.Inject

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
@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository):ViewModel(){
    private val _response= MutableLiveData<List<String>>()
    val VMresponse:LiveData<List<String>> = _response

    init {
        GetAllContrys()
    }

    private fun GetAllContrys()= viewModelScope.launch {
        mainRepository.GetContrys().let { response ->
            if(response.isSuccessful){

                val originalList: List<Data> = response.body()!!
                val newList: List<String> = originalList
                    .sortedBy { it.name.common }
                    .map { it.name.common }
                newList.sorted()
                _response.postValue(newList)

            }
            else{
                Log.e("tag","error:${response.code()}")
            }
        }
    }
}