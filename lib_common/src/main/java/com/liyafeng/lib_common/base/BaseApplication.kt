package com.liyafeng.lib_common.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.drawee.backends.pipeline.Fresco
import com.liyafeng.lib_common.AppUtil

//open 可继承，默认不可继承
open class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        if (AppUtil.isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)

        //Fresco init
        Fresco.initialize(this);
    }
}