package net.vezk.contact_form

import com.google.gson.annotations.SerializedName

data class data(
    @SerializedName("name") val name: name
)
data class name(
    @SerializedName("common") val common: String
)


