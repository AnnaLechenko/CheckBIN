package com.annalech.checkbin.utility

import com.annalech.checkbin.data.database.BinInfoDBModel
import com.annalech.checkbin.data.network.model.BinInfo

object Mapper {

    fun formatBinInfoInDbModel(bin:String,binInfo: BinInfo):BinInfoDBModel{
        val statusPrepaid = if(binInfo.prepaid == true){
            "Да"
        }else{
            "Информация отсутствует"
        }
        return BinInfoDBModel(
            bin = bin.toLong(),
            scheme = binInfo.scheme  ?: "Информация отсутствует",
            brand = binInfo.brand ?: "Информация отсутствует",
            type = binInfo.type ?: "Информация отсутствует",
            prepaid = statusPrepaid ,
            country = binInfo.country?.name ?: "Информация отсутствует",
            bankName = binInfo.bank?.name ?: "Информация отсутствует",
            bankCity = binInfo.bank?.city ?: "Информация отсутствует",
            bankUrl = binInfo.bank?.url ?: "Информация отсутствует",
            bankPhone = binInfo.bank?.phone ?: "Информация отсутствует"
        )
    }
}