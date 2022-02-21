package com.wpf.common_base.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 *    author : whs
 *    e-mail : haisilen@163.com
 *    date   : 2022/2/7 16:48
 *    desc   :时间工具类
 */
object CalendarUtils {

    fun getCalendar(dateStr: String?, formatStr: String?): Calendar? {
        val date: Date? = StringToDate(dateStr, formatStr)
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar
        }
        return null
    }

    /**
     * 字符串转date
     */
    @SuppressLint("SimpleDateFormat")
    fun StringToDate(dateStr: String?, formatStr: String?): Date? {
        return if (TextUtils.isEmpty(dateStr) || TextUtils.isEmpty(formatStr)) null else try {
            val dd = SimpleDateFormat(formatStr)
            dd.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }

    fun getDateString_(date: Calendar): String? {
        val year = date[Calendar.YEAR]
        val month = date[Calendar.MONTH]
        val dayOfMonth = date[Calendar.DAY_OF_MONTH]
        val hour = date[Calendar.HOUR_OF_DAY]
        val minute = date[Calendar.MINUTE]
        return String.format(Locale.getDefault(), "%d-%02d-%02d", year, month + 1, dayOfMonth)
    }
}