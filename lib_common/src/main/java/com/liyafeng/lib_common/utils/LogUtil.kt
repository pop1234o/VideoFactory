package com.liyafeng.lib_common.utils

import android.util.Log

object LogUtil {

    var isDebug = true

    fun i(tag: String?, s: String?) {
        if (isDebug) {
            if (s != null && s.length > 4000) {
                printLongI(tag, s)
            } else {
                Log.i(tag, s)
            }
        }
    }

    fun i(content: String?) {
        i("test", content)
    }

    fun w(tag: String?, s: String?) {
        if (isDebug) {
            Log.w(tag, s)
        }
    }

    fun e(tag: String?, s: String?) {

        if (isDebug) {
            if (s != null && s.length > 4000) {
                printLongE(tag, s)
            } else {
                Log.e(tag, s)
            }
        }
    }

    fun d(tag: String?, s: String?) {
        if (isDebug) {
            Log.d(tag, s)
        }
    }

    private fun printLongI(tag: String?, s: String?) {
        var i = 0
        if (s == null) {
            return
        }
        while (i < s.length) {
            if (i + 4000 < s.length) Log.i(
                tag + i,
                s.substring(i, i + 4000)
            ) else Log.i(tag + i, s.substring(i, s.length))
            i += 4000
        }
    }

    private fun printLongE(tag: String?, s: String?) {
        var i = 0
        if (s == null) {
            return
        }
        while (i < s.length) {
            if (i + 4000 < s.length) Log.e(
                tag + i,
                s.substring(i, i + 4000)
            ) else Log.e(tag + i, s.substring(i, s.length))
            i += 4000
        }
    }
}