package com.wpf.func_home.ui

import android.os.Bundle
import com.wpf.common_player.base.StatedMediaPlay
import com.wpf.common_player.control.IOnPlayProgressListener
import com.wpf.common_player.control.PlayerControl
import com.wpf.common_ui.base.BaseActivity
import com.wpf.func_home.databinding.ActPlaySoundTestBinding

/**
 *  Author: feipeng.wang
 *  Time:   2021/12/9
 *  Description : 测试播放器
 */
class PlaySoundTestAct : BaseActivity<ActPlaySoundTestBinding>() {
    private val statedMediaPlay by lazy { StatedMediaPlay() }
    private val fileName = "/storage/emulated/0/wpf/AsrDemo3/max.wav"
    private var isPlay = false


    override fun onCreateAfter(savedInstanceState: Bundle?) {
        mViewBinding.apply {
            playFileName.text = fileName
        }
        initClick()
    }

    private fun initClick() {
        mViewBinding.btPlay.setOnClickListener {
            if (isPlay){
                isPlay = false
                mViewBinding.btPlay.text = "播放"
                PlayerControl.instance.pause()
            }else{
                isPlay = true
                mViewBinding.btPlay.text = "暂停"
//                statedMediaPlay.play(fileName)
                PlayerControl.instance.play(fileName)
            }
            val wavmixPath = fileName
//            statedMediaPlay.play(fileName)
/*                statedMediaPlay.pause()
                statedMediaPlay.resume()*/
        }
        mViewBinding.seekBar.setOnClickListener {

        }
        mViewBinding.btSpeed.setOnClickListener {
            PlayerControl.instance.onDerailleur((mViewBinding.etSpeed.text.toString().toFloat()))
        }
        mViewBinding.btAfterTime.setOnClickListener {
            PlayerControl.instance.seekTo(PlayerControl.instance.getPlayingPosition()+15*1000)
        }
        mViewBinding.btBeforeTime.setOnClickListener {
            PlayerControl.instance.seekTo(PlayerControl.instance.getPlayingPosition()-15*1000)
        }
        PlayerControl.instance.setOnPlayProgressListener(object : IOnPlayProgressListener{
            override fun onPlayProgress(currPos: Long, duration: Long) {

                mViewBinding.seekBar.progress = (currPos*100/duration).toInt()
                mViewBinding.tvCurrentTime.text = (currPos/1000).toString()
                mViewBinding.tvAllTime.text = (duration/1000).toString()
            }

        })
    }
}