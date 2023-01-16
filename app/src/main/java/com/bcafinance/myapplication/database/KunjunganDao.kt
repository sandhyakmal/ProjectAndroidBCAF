package com.bcafinance.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bcafinance.myapplication.model.DataKunjunganLocal

@Dao
interface KunjunganDao {
    @Insert
    fun insertKunjungan(kunjungan: DataKunjunganLocal)

    @Delete
    fun deleteDummy(kunjungan: DataKunjunganLocal)

    @Query("Select * from DataKunjunganLocal")
    fun getAll():List<DataKunjunganLocal>
}