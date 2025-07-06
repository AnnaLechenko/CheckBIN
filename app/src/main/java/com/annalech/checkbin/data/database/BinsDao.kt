package com.annalech.checkbin.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BinsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBinInDB(binInfo: BinInfoDBModel)

    @Query("SELECT * FROM bin_item_tabl ")
    fun getAllBinInfo(): LiveData<List<BinInfoDBModel>>

}