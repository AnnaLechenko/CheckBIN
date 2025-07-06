package com.annalech.checkbin.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BinInfoDBModel::class], version = 1, exportSchema = false)
abstract class BinDataBase():RoomDatabase() {

    abstract fun binsDao():BinsDao

    companion object{
        private var INSTANCE:BinDataBase?=null
        private val LOCK = Any()
        private const val DB_NAME =  "binDataBase"

        fun getInstance (application: Application):BinDataBase{
            INSTANCE?.let {db->
                return db
            }
            synchronized(lock = LOCK){
                val db = Room.databaseBuilder(
                    application,
                    BinDataBase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = db
                return db
            }
        }
    }
}