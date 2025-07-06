package com.annalech.checkbin.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Database(
    entities = [BinInfoDBModel::class],
    version = 1,
    exportSchema = false)
abstract class BinDataBase  : RoomDatabase() {

    abstract fun binsDao(): BinsDao

}