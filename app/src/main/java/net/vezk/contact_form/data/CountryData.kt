package net.vezk.contact_form.data

/**
 * πͺπΈ
 * siendo este el formato del Json de entrada
 *[{"name":
 *  {"common":
 *  se crearon un par de data class [Data] y [Name]
 *
 * πΊπΈ
 * this being the input Json format
 *[{"Name":
 * {"common":
 * a pair of data class [Data] and [Name] were created
 * **/
data class Data(
    val name: Name
)

data class Name(
    val common: String
)

class CountryResponse:ArrayList<Data>()

