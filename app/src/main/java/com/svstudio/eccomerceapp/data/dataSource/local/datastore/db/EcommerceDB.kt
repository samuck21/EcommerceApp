package com.svstudio.eccomerceapp.data.dataSource.local.datastore.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.svstudio.eccomerceapp.data.dataSource.local.dao.CategoriesDao
import com.svstudio.eccomerceapp.data.dataSource.local.dao.ProductsDao

import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity
import com.svstudio.eccomerceapp.data.dataSource.local.entity.ProductEntity


@Database(
    entities = [CategoryEntity::class, ProductEntity::class],
    version = 2,
  exportSchema = false
)
abstract class EcommerceDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao// DATA ACCESS OBJECT
    abstract  fun productsDao(): ProductsDao
}