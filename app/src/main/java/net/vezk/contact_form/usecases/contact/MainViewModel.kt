package net.vezk.contact_form.usecases.contact

import androidx.lifecycle.*
import net.vezk.contact_form.model.domain.Data
import retrofit2.*


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