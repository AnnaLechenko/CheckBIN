package com.annalech.checkbin.data.network.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Country (

    @SerialName("numeric"   ) var numeric   : String? = null,
    @SerialName("alpha2"    ) var alpha2    : String? = null,
    @SerialName("name"      ) var name      : String? = null,
    @SerialName("emoji"     ) var emoji     : String? = null,
    @SerialName("currency"  ) var currency  : String? = null,
    @SerialName("latitude"  ) var latitude  : Int?    = null,
    @SerialName("longitude" ) var longitude : Int?    = null

)