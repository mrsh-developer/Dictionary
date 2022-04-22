package mrsh.com.besh.sakkiz.dictionary.dao

import androidx.room.*
import mrsh.com.besh.sakkiz.dictionary.entity.Categoriya


@Dao
interface CategoriyaInterface {

    @Transaction
    @Query("select * from Categoriya")
    fun getCategory(): List<Categoriya>

    @Insert
    fun addCategory(categoriya: Categoriya)

    @Update()
    fun updateCategory(categoriya: Categoriya)

    @Delete
    fun deleteCategory(categoriya: Categoriya)


}