package com.annalech.checkbin.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Number(

    @SerialName("length" ) var length : Int?     = null,
    @SerialName("luhn"   ) var luhn   : Boolean? = null

)
