package com.wpf.common_player.control

/**
 *  Author: feipeng.wang
 *  Time:   2021/12/16
 *  Description : This is description.
 */
/**
 * 进度监听
 */
interface IOnPlayProgressListener {
    fun onPlayProgress(currPos: Long, duration: Long)
}
