package com.liyafeng.lib_common.utils;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public interface IApplicationDelegate {

    void onCreate(Context context);

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

}
