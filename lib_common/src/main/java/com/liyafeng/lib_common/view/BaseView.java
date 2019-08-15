package com.liyafeng.lib_common.view;

/**
 * Created by zhanglin on 2018/1/16.
 */

public interface BaseView {

    void showErrorToast(String content);

    void showSuccessToast(String content);

    void showWarningToast(String content);

    void showFloatLoading();

    void hideFloatLoading();

}
