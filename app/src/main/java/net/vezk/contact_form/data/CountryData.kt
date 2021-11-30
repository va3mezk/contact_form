package net.vezk.contact_form.data

import com.google.gson.annotations.SerializedName

/**
 * 🇪🇸
 * siendo este el formato del Json de entrada
 *[{"name":
 *  {"common":
 *  se crearon un par de data class [Data] y [Name]
 *
 * 🇺🇸
 * this being the input Json format
 *[{"Name":
 * {"common":
 * a pair of data class [Data] and [Name] were created
 * **/
data class Data(
    @SerializedName("name") val name: Name
)

data class Name(
    @SerializedName("common") val common: String
)


