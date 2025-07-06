package com.annalech.checkbin.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BinInfo(

    @SerialName("number"  ) var number  : Number?  = Number(),
    @SerialName("scheme"  ) var scheme  : String?  = null,
    @SerialName("type"    ) var type    : String?  = null,
    @SerialName("brand"   ) var brand   : String?  = null,
    @SerialName("prepaid" ) var prepaid : Boolean? = null,
    @SerialName("country" ) var country : Country? = Country(),
    @SerialName("bank"    ) var bank    : Bank?    = Bank()
)

