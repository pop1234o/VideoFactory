package com.liyafeng.lib_common.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liyafeng.lib_common.view.BaseView
import com.tbruyelle.rxpermissions2.RxPermissions

abstract class BaseFragment : Fragment(), BaseView, View.OnClickListener {
    private var lastClickTime: Long = 0
    val MIN_CLICK_DELAY_TIME = 800

    //懒加载，只能是val
    private val mPermission: RxPermissions by lazy {
        RxPermissions(this)
    }

    open fun getPermission(): RxPermissions {
        return mPermission
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(view);
    }

    abstract fun initData(view: View)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int


    override fun showErrorToast(content: String) {
        val activity = activity
        if (activity is BaseActivity) {
            activity.showErrorToast(content)
        }
    }


    override fun showSuccessToast(content: String) {
        val activity = activity
        if (activity is BaseActivity) {
            activity.showSuccessToast(content)
        }
    }


    override fun showWarningToast(content: String) {
        val activity = activity
        if (activity is BaseActivity) {
            activity.showWarningToast(content)
        }
    }


    override fun showFloatLoading() {
        val activity = activity
        if (activity is BaseActivity) {
            activity.showFloatLoading()
        }
    }

    override fun hideFloatLoading() {
        val activity = activity
        if (activity is BaseActivity) {
            activity.hideFloatLoading()
        }
    }


    override fun onClick(v: View) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime
            onNoDoubleClick(v)
        }
    }

    protected open fun onNoDoubleClick(v: View) {

    }
}
