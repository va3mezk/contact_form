package net.vezk.contact_form.usecases.contact

import net.vezk.contact_form.provider.services.ApiInterface


class MainRepository constructor(private val retrofitService: ApiInterface) {
    fun getCountry() = retrofitService.getCountry()
}