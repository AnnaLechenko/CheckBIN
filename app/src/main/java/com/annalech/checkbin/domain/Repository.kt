package com.annalech.checkbin.domain

import androidx.lifecycle.LiveData
import com.annalech.checkbin.data.database.BinInfoDBModel

interface Repository {

     fun getAllSaveBins():LiveData<List<BinInfoDBModel>>
    suspend fun saveBinInDb(bin: BinInfoDBModel)

}