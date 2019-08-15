package com.github.ybq.android.spinkit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.github.ybq.android.spinkit.R;
import com.github.ybq.android.spinkit.SpinKitView;

public class LoadingDialog extends Dialog {


    public LoadingDialog(Context context) {
        super(context, R.style.popupDialog);
        createDialog();
    }

    public void createDialog() {
        setContentView(R.layout.common_layout_loading);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


    }

    public void setLoadingColor(int color) {
        try {
            SpinKitView spin_kit = findViewById(R.id.spin_kit);
            spin_kit.setColor(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
