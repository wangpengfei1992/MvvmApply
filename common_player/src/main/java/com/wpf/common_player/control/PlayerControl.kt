package com.wpf.common_player.control

import android.app.Application
import com.lzx.starrysky.OnPlayProgressListener
import com.lzx.starrysky.SongInfo
import com.lzx.starrysky.StarrySky
import com.wpf.common_player.utils.MD5Util

/**
 *  Author: feipeng.wang
 *  Time:   2021/12/9
 *  Description : This is description.
 */
class PlayerControl private constructor(){
    private var playType:Int = 0;
    companion object{
        val instance:PlayerControl by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            PlayerControl()
        }
    }
    /*初始化*/
    fun init(application: Application, type:Int = 0) {
        playType = type
        if (type == 0){
            StarrySky.init(application).apply()
        }
    }
    /*播放*/
    fun play(filePath:String) {
        if (playType == 0){
            //简单播放一首歌曲
            val info = SongInfo()
            info.songId = getId(filePath)
            info.songUrl = filePath
            StarrySky.with().playMusicByInfo(info)
        }
    }
    /*暂停*/
    fun pause() {
        if (playType == 0){
            StarrySky.with().pauseMusic()
        }
    }
    /*恢复播放*/
    fun restoreMusic() {
        if (playType == 0){
            StarrySky.with().restoreMusic()
        }
    }
    /*快进 每调一次加 speed 倍*/
    fun fastForward(speed:Float) {
        if (playType == 0){
            StarrySky.with().fastForward(speed)
        }
    }
    /*快退 每调一次减 speed 倍*/
    fun rewind(speed:Float) {
        if (playType == 0){
            StarrySky.with().rewind(speed)
        }
    }
    /*配置任意倍速*/
    fun onDerailleur(multiple: Float,refer: Boolean = false) {
        if (playType == 0){
            StarrySky.with().onDerailleur(refer, multiple)
        }
    }
    /* 移动到媒体流中的新位置,以毫秒为单位*/
    fun seekTo(pos: Long) {
        if (playType == 0){
            StarrySky.with().seekTo(pos)
        }
    }
    /* 获取播放位置 毫秒为单位*/
    fun getPlayingPosition(): Long {
        if (playType == 0){
            return StarrySky.with().getPlayingPosition()
        }
        return 0;
    }
    /**
     * 设置进度监听
     */
    fun setOnPlayProgressListener(listener: IOnPlayProgressListener) {
        if (playType == 0){
            StarrySky.with().setOnPlayProgressListener(object : OnPlayProgressListener{
                override fun onPlayProgress(currPos: Long, duration: Long) {
                    listener?.onPlayProgress(currPos,duration)
                }
            })
        }
    }
    //获取字符串md5
    fun getId(filePath:String):String{
        return MD5Util.string2MD5(filePath)
    }

}