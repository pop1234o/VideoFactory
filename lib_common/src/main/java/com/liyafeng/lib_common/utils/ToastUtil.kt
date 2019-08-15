package com.liyafeng.lib_common.utils

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.liyafeng.lib_common.R
import com.liyafeng.lib_common.base.BaseApplication

object ToastUtil {

    @JvmStatic
    fun showError(content: String) {
        showToast(content, R.drawable.common_icon_failure)
    }

    @JvmStatic
    fun showSuccess(content: String) {
        showToast(content, R.drawable.common_icon_success)
    }

    @JvmStatic
    fun showWarning(content: String) {
        showToast(content, R.drawable.common_icon_warning)
    }

    private fun showToast(content: String, resId: Int) {
        try {
            val instance = BaseApplication.getInstance()
            val toast = Toast(instance)
            val view = LayoutInflater.from(instance).inflate(R.layout.common_toast, null)
            val ivToastIcon = view.findViewById<ImageView>(R.id.ivToastIcon)
            val tvToastText = view.findViewById<TextView>(R.id.tvToastText)

            ivToastIcon.setImageResource(resId)
            tvToastText.text = content
            toast.view = view
            toast.setGravity(Gravity.CENTER, 0, 0)

            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
