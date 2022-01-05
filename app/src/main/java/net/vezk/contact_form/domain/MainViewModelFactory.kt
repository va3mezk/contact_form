package net.vezk.contact_form.domain

import androidx.lifecycle.*


/**
 * 🇪🇸
 *En la configuración de ViewModel, necesitamos crear una clase y extender ViewModel.
 * La clase ViewModel que tiene la lógica de negocios y las implementaciones de llamadas a la API.
 * En el constructor ViewModel, necesitamos pasar el repositorio de datos para manejar los datos.
 *
 * 🇺🇸
 * In the ViewModel configuration, we need to create a class and extend ViewModel.
 * The ViewModel class that has the business logic and API call implementations.
 * In the ViewModel constructor, we need to pass the data repository to handle the data.
 **/
class MainViewModelFactory constructor(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}