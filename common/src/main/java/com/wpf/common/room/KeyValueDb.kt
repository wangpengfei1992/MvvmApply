package com.wpf.common.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wpf.common_base.utils.ContextUtil

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/20
 *  Description : This is description.
 */
@Database(entities = [KeyValueEntity::class],version = 1,exportSchema = false)
abstract class KeyValueDb : RoomDatabase(){
    abstract fun getKeyValueDao():KeyValueDao
    companion object{
        private const val DB_NAME = "KeyValueDb.db"
        @Volatile
        private var keyValueDb:KeyValueDb?=null

        @Synchronized
        fun getInstance():KeyValueDb{
            if (keyValueDb == null) {
                keyValueDb = create()
            }
            return keyValueDb!!
        }

        fun create():KeyValueDb{
            return Room.databaseBuilder(ContextUtil.getContext(),KeyValueDb::class.java, DB_NAME).build()
        }

    }
}