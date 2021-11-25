package net.vezk.contact_form.model.domain

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name") val name: Name
)

data class Name(
    @SerializedName("common") val common: String
)


