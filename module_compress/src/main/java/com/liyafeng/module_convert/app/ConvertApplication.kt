package com.liyafeng.module_convert.app

import android.content.Context
import com.bilibili.boxing.BoxingMediaLoader
import com.liyafeng.lib_common.utils.IApplicationDelegate
import com.liyafeng.module_convert.image.BoxingFrescoLoader


class ConvertApplication : IApplicationDelegate {
    override fun onCreate(context: Context) {
        // a class implements IBoxingMediaLoader
        BoxingMediaLoader.getInstance()
            .init(BoxingFrescoLoader(context))

    }

    override fun onTerminate() {
    }

    override fun onLowMemory() {
    }

    override fun onTrimMemory(level: Int) {
    }
}