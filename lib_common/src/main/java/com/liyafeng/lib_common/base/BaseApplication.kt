package com.liyafeng.lib_common.base

import android.app.Activity
import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.drawee.backends.pipeline.Fresco
import com.liyafeng.lib_common.AppUtil
import java.util.*

//open 可继承，默认不可继承
open class BaseApplication : Application() {


    private val activities = ArrayList<Activity>()


    //生成一个静态的伴生对象
    companion object {
        private lateinit var mInstance: BaseApplication

        @JvmStatic
        fun getInstance(): BaseApplication {
            return mInstance
        }
    }


    override fun onCreate() {
        super.onCreate()
        mInstance = this
        if (AppUtil.isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)

        //Fresco init
        Fresco.initialize(this)

    }


    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun getTopActivity(): Activity? {
        return if (activities.size > 0) {
            activities.get(activities.size - 1)
        } else null
    }

    /**
     * 关闭所有activity
     */
    fun closeActivity() {
        for (activity in activities) {
            activity.finish()
        }
    }
}