package com.liyafeng.module_convert.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bilibili.boxing.Boxing
import com.bilibili.boxing.model.config.BoxingConfig
import com.bilibili.boxing_impl.ui.BoxingActivity
import com.liyafeng.lib_common.base.BaseFragment
import com.liyafeng.lib_common.utils.LogUtil
import com.liyafeng.module_convert.R
import kotlinx.android.synthetic.main.convert_fragment_main.*


// TODO: Rename parameter arguments, choose names that match
val ARG_1 = "1"
const val ARG_2 = "2"

private val ARG_3 = "3"
private const val ARG_4 = "4"


class MainConvertFragment : BaseFragment() {

    private val REQUEST_CODE = 1024

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun getLayoutId() = R.layout.convert_fragment_main


    override fun initData(view: View) {

        btnDialog.setOnClickListener(this)
    }

    override fun onNoDoubleClick(v: View) {
        val id = v.id;
        if (R.id.btnDialog == id) {

            val disposable = getPermission().request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe { isGaint ->
                    if (isGaint) {
                        selectVideo()
                    } else {
                        showErrorToast("请先授权")
                    }
                }


        }
    }

    private fun selectVideo() {
        val videoConfig =
            BoxingConfig(BoxingConfig.Mode.VIDEO).withVideoDurationRes(R.mipmap.ic_boxing_play)
        Boxing.of(videoConfig).withIntent(
            context,
            BoxingActivity::class.java
        ).start(this, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val medias = Boxing.getResult(data)
        if (requestCode == REQUEST_CODE) {
            if (medias != null && medias.size > 0) {
                LogUtil.i("===========" + medias[0].size)
            } else {
                showErrorToast("请选择视频")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainConvertFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            MainConvertFragment().apply {
                //                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}
