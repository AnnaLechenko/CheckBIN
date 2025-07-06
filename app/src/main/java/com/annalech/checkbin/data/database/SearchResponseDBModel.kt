package com.annalech.checkbin.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_item_tabl")
data class BinInfoDBModel(
    @PrimaryKey
    val bin: Long,
    val scheme: String? = "Информация отсутствует",
    val brand: String? = "Информация отсутствует",
    val type: String? = "Информация отсутствует",
    val prepaid: String? = "Информация отсутствует",
    val country: String? = "Информация отсутствует",
    val bankName: String? = "Информация отсутствует",
    val bankCity: String? = "Информация отсутствует",
    val bankUrl: String? = "Информация отсутствует",
    val bankPhone: String? = "Информация отсутствует"

)