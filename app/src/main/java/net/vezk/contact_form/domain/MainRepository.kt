@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection"
)

package net.vezk.contact_form.domain

import net.vezk.contact_form.data.ApiInterface

/**
 *s🇪🇸
 ** Estoy usando un patrón de repositorio para manejar los datos de la API. En la clase de repositorio,
 * Necesitamos pasar la instancia del servicio de actualización para realizar la llamada de red.
 * No es necesario que manejemos la respuesta aquí en el repositorio. Eso será parte de ViewModel.
 *
 * 🇺🇸
 * I am using a repository pattern to handle the data from API. In the repository class,
 * we need to pass the retrofit service instance to perform the network call.
 * We don’t need to handle the response here in the repository. That will be part of the ViewModel.
 **/
class MainRepository constructor(private val retrofitService: ApiInterface) {
    fun getCountry() = retrofitService.getCountry()
}