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
            scheme = binInfo.scheme,
            brand = binInfo.brand,
            type = binInfo.type,
            prepaid = statusPrepaid,
            country = binInfo.country?.name,
            bankName = binInfo.bank?.name,
            bankCity = binInfo.bank?.city,
            bankUrl = binInfo.bank?.url,
            bankPhone = binInfo.bank?.phone
        )
    }
}