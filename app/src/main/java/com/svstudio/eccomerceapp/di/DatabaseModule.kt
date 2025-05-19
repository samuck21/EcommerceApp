package com.svstudio.eccomerceapp.di

import android.app.Application
import androidx.room.Room
import com.svstudio.eccomerceapp.data.dataSource.local.dao.CategoriesDao
import com.svstudio.eccomerceapp.data.dataSource.local.datastore.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun privideDataBase(app: Application): EcommerceDB =
        Room.databaseBuilder(app, EcommerceDB::class.java,"ecommerce_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCategoriesDao(db: EcommerceDB): CategoriesDao = db.categoriesDao()
}