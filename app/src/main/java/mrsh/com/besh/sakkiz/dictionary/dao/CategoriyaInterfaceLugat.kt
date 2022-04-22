package mrsh.com.besh.sakkiz.dictionary.dao

import androidx.room.*
import mrsh.com.besh.sakkiz.dictionary.entity.Categoriya
import mrsh.com.besh.sakkiz.dictionary.entity.Lugat

@Dao
interface CategoriyaInterfaceLugat {

    @Transaction
    @Query("select * from Lugat")
    fun getLugat(): List<Lugat>

    @Insert
    fun addLugat(lugat: Lugat)

    @Update()
    fun updateLugat(lugat: Lugat)

    @Delete
    fun deleteLugat(lugat: Lugat)


}