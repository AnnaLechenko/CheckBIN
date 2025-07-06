package com.annalech.checkbin.di

import android.content.Context
import androidx.room.Room
import com.annalech.checkbin.data.RepositoryImpl
import com.annalech.checkbin.data.database.BinDataBase
import com.annalech.checkbin.data.database.BinsDao
import com.annalech.checkbin.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface ModuleApp {

    @Singleton
    @Binds
    fun bindExampleRepository(impl:  RepositoryImpl): Repository

    companion object{

        @Singleton
        @Provides
        fun provideDB(
            @ApplicationContext context: Context
        ):BinDataBase{
            return Room.databaseBuilder(
                context  = context,
                klass = BinDataBase::class.java,
                name = "bins.db"
            ).build()
        }

        @Singleton
        @Provides
        fun provideBinDao(
            database: BinDataBase
        ):BinsDao{
            return database.binsDao()
        }
    }

}