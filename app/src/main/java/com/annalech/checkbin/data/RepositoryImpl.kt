package com.annalech.checkbin.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.annalech.checkbin.data.database.BinDataBase
import com.annalech.checkbin.data.database.BinInfoDBModel
import com.annalech.checkbin.domain.Repository

class RepositoryImpl(val application: Application):Repository
{
    override  fun getAllSaveBins(): LiveData<List<BinInfoDBModel>> {
        return BinDataBase.getInstance(application = application).binsDao().getAllBinInfo()
    }

    override suspend fun saveBinInDb(bin: BinInfoDBModel) {
        BinDataBase.getInstance(application = application).binsDao().insertBinInDB(bin)
    }
}