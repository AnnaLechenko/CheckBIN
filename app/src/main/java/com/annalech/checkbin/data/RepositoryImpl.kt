package com.annalech.checkbin.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.annalech.checkbin.data.database.BinDataBase
import com.annalech.checkbin.data.database.BinInfoDBModel
import com.annalech.checkbin.data.database.BinsDao
import com.annalech.checkbin.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val binDB: BinsDao):Repository
{
    override  fun getAllSaveBins(): LiveData<List<BinInfoDBModel>> {
        return  binDB.getAllBinInfo()
    }

    override suspend fun saveBinInDb(bin: BinInfoDBModel) {
       binDB.insertBinInDB(bin)
    }
}