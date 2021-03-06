package com.wpf.common_player.base;

/**
 * Author: feipeng.wang
 * Time:   2021/11/17
 * Description : This is description.
 */
public interface IPlayerListener {
    /**
     * 正在准备播放当前的文件
     * @param filePath
     */
    void onPreparing(String filePath);

    /**
     * 当前文件的播放准备完毕
     * @param filePath
     */
    void onPrepared(String filePath);

    /**
     * 暂停播放当前文件
     * @param filePath
     */
    void onPause(String filePath);

    /**
     * 正在播放当前文件
     * @param filePath
     */
    void onPlay(String filePath);

    /**
     * 播放当前文件出错
     * @param filePath
     * @param what
     * @param extra
     */
    void onError(String filePath, int what, int extra);

    /**
     * 当前文件播放停止(停止,可能是由于播放其他文件停止)
     * @param filePath
     */
    void onStopped(String filePath);

    /**
     * 当前文件播放完成,正常播放完成
     * @param filePath
     */
    void onComplete(String filePath);

}