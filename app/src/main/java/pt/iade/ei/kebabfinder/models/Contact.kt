package pt.iade.ei.kebabfinder.models

import java.io.Serializable

data class Contact(
    val type: String,
    val value: String
) : Serializable
