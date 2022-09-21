package com.harsh.grocerylister.database

import com.harsh.grocerylister.database.GroceryDatabase
import com.harsh.grocerylister.database.GroceryItems

class GroceryRepository(private val db: GroceryDatabase) {

       suspend fun insert(items: GroceryItems) = db.getGroceryDao().insert(items)

    suspend fun delete(items: GroceryItems) = db.getGroceryDao().delete(items)


    fun getAllItems() = db.getGroceryDao().getAllGroceryItems()
}