package pt.iade.ei.kebabfinder.models

import java.net.URI

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val location: GeoCoord,
    val rating: Float,
    val address: String,
    val contacts: List<Contact>?,
    val openingHours: Array<List<Int>>?,
    val image: URI
)
