package com.longsh.mvvm.ui.home

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.longsh.mvvm.R
import com.longsh.mvvm.base.BaseActivity
import com.longsh.mvvm.databinding.ActivityMainBinding
import java.util.*


class MainActivity : BaseActivity<MainModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        dataBinding.model = vm
        vm.data.observe(this, Observer {

        })
        dataBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        val testAdapter  = TestAdapter(this)
        dataBinding.recyclerView.adapter = testAdapter
        vm.listData.observe(this,{
            Log.d("MainActivityLog","size = ${it.size}")
            testAdapter.setList(it)
            testAdapter.notifyDataSetChanged()
        })
    }

    override fun initData() {
//        vm.getFlowTestData()
        vm.getListData()
    }

//    fun getScreenBrightness(): Int {
//        var value = 0
//        val cr = contentResolver
//        try {
//            value = Settings.System.getInt(cr, Settings.System.SCREEN_BRIGHTNESS)
//        } catch (e: SettingNotFoundException) {
//        }
//        return value
//    }


}