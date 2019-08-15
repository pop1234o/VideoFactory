package com.liyafeng.videofactory.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.liyafeng.lib_common.base.BaseActivity
import com.liyafeng.videofactory.R
import com.liyafeng.videofactory.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                vpMain.currentItem = 0;
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                vpMain.currentItem = 1;
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        vpMain.adapter = MainAdapter(supportFragmentManager);
    }
}
