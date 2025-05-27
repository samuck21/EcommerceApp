package com.svstudio.eccomerceapp.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.svstudio.eccomerceapp.data.dataSource.local.entity.ShoppingBagProductEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface ShoppingBagDao {

    // INSERT INTO categories VALUES
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: ShoppingBagProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(product: List<ShoppingBagProductEntity>)

    @Query("SELECT SUM(quantity * price) FROM shopping_bag" )
    suspend fun getTotal(): Double

    @Query("SELECT * FROM shopping_bag")
    fun findAll(): Flow<List<ShoppingBagProductEntity>>

    @Query("SELECT * FROM shopping_bag WHERE id = :id")
    fun findById(id: String): ShoppingBagProductEntity

    @Query("UPDATE shopping_bag SET  quantity = :quantity  WHERE id = :id")
    suspend fun update(id: String, quantity: Int)

    @Query("DELETE FROM shopping_bag WHERE id = :id")
    suspend fun delete(id: String)

}