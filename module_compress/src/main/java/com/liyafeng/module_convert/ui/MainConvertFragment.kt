package com.liyafeng.module_convert.ui

import android.os.Bundle
import android.view.View
import com.liyafeng.lib_common.base.BaseFragment
import com.liyafeng.lib_common.utils.AppUtil
import com.liyafeng.module_convert.R
import kotlinx.android.synthetic.main.convert_fragment_main.*


// TODO: Rename parameter arguments, choose names that match
val ARG_1 = "1"
const val ARG_2 = "2"

private val ARG_3 = "3"
private const val ARG_4 = "4"


class MainConvertFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun getLayoutId() = R.layout.convert_fragment_main


    override fun initData(view: View) {

//        btnDialog.setOnClickListener {
//
//            showFloatLoading()
//            AppUtil.mainHandler.postDelayed({
//                hideFloatLoading()
//            }, 5000);
//        }
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
