package com.wpf.common.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Author: feipeng.wang
 *  Time:   2021/7/20
 *  Description : KeyValue对象
 */
@Entity
class KeyValueEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var key: String? = null
    var value: String? = null
    constructor(
        id: Long = 0,
        key: String? = null,
        value: String? = null,
    ) {
        this.id = id
        this.key = key
        this.value = value
    }

    override fun toString(): String {
        return "KeyValueEntity(id=$id, key=$key, value=$value)"
    }
}