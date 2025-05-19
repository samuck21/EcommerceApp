package com.svstudio.eccomerceapp.data.dataSource.local.datastore.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.svstudio.eccomerceapp.data.dataSource.local.dao.CategoriesDao

import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity


@Database(
    entities = [CategoryEntity::class],
    version = 1,
  exportSchema = false
)
abstract class EcommerceDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao// DATA ACCESS OBJECT
}