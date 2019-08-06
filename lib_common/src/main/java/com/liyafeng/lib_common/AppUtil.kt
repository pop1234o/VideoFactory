package com.liyafeng.lib_common

object AppUtil {

    //定义常量
    val DEBUG = "debug"
    val RELEASE = "release"

    //字符串比较
    fun isDebug() = DEBUG == BuildConfig.BUILD_TYPE


}