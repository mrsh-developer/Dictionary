package mrsh.com.besh.sakkiz.dictionary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mrsh.com.besh.sakkiz.dictionary.dao.CategoriyaInterfaceLugat
import mrsh.com.besh.sakkiz.dictionary.entity.Categoriya
import mrsh.com.besh.sakkiz.dictionary.entity.Lugat

@Database(entities = [Lugat::class], version = 1)
abstract class MyDBLugat : RoomDatabase() {

    abstract fun categoryDaoLugat(): CategoriyaInterfaceLugat

    companion object {
        private var instance: MyDBLugat? = null

        @Synchronized
        fun getInstance(context: Context): MyDBLugat {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MyDBLugat::class.java, "news_db1")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}