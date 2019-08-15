package com.liyafeng.lib_common.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.github.ybq.android.spinkit.dialog.LoadingDialog
import com.liyafeng.lib_common.R
import com.liyafeng.lib_common.utils.ToastUtil
import com.liyafeng.lib_common.view.BaseView

/**
 *
 */
open class BaseActivity : AppCompatActivity(), View.OnClickListener, BaseView {
    private var lastClickTime: Long = 0
    private var loadingDialog: LoadingDialog? = null
    val MIN_CLICK_DELAY_TIME = 800

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.getInstance().addActivity(this)
        ARouter.getInstance().inject(this)
    }


    override fun onDestroy() {
        BaseApplication.getInstance().removeActivity(this)
        super.onDestroy()
    }


    override fun showErrorToast(content: String) {
        ToastUtil.showError(content)
    }


    override fun showSuccessToast(content: String) {
        ToastUtil.showSuccess(content)
    }


    override fun showWarningToast(content: String) {
        ToastUtil.showWarning(content)
    }

    override fun showFloatLoading() {

        try {
            if (loadingDialog == null) {
                loadingDialog = LoadingDialog(this)
                loadingDialog?.setLoadingColor(resources.getColor(R.color.colorAccent))
            }
            loadingDialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun hideFloatLoading() {
        try {
            loadingDialog?.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    override fun onClick(v: View) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime
            onNoDoubleClick(v)
        }
    }

    protected fun onNoDoubleClick(v: View) {

    }

}
