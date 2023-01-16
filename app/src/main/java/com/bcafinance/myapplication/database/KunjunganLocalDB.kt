package com.bcafinance.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcafinance.myapplication.model.DataKunjunganLocal

@Database(version = 1, entities = [DataKunjunganLocal::class])
@TypeConverters(ListStringConverter::class)
abstract class KunjunganLocalDB:RoomDatabase() {
    abstract fun kunjunganDao():KunjunganDao

    companion object{
        var instance: KunjunganLocalDB?=null
        fun getInstance(ctx: Context):KunjunganLocalDB{
            if(instance == null){
                instance = Room.databaseBuilder(ctx.applicationContext, KunjunganLocalDB::class.java, "kunjungan_db")
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }
    }
}