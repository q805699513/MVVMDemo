package com.longsh.mvvm.ui.home

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.longsh.mvvm.base.BaseViewModel
import com.longsh.mvvm.model.TestBean
import com.longsh.mvvm.net.AppHttpMethods
import com.longsh.mvvm.net.exception.ExceptionHandle
import kotlinx.coroutines.flow.*

/**
 * @author LongShaoHua
 * @date 20-7-15
 */
class MainModel : BaseViewModel() {

    var data = MutableLiveData<String>()
    var listData = MutableLiveData<ArrayList<String>>()
    private val mainRepository = MainRepository()

    fun onClick(view: View) {
        // 点击事件
        data.value = "onClick"

    }

    fun getTestData() {
        launchGo(
            {
                val bean = AppHttpMethods.instance.getTestData(0)
                if (bean.isOk) {
                    data.value = "code = " + bean.errorCode
                } else {
                    data.value = "code = " + bean.errorCode
                }
            }
        )
    }

    fun getFlowTestData() {
        launchUI {
            launchFlow { AppHttpMethods.instance.getTestData(0) }
                .flatMapConcat {
                    if (it.isOk) {
                        return@flatMapConcat launchFlow { AppHttpMethods.instance.getTestData(0) }
                    } else {
                        return@flatMapConcat launchFlow { AppHttpMethods.instance.getTestData(0) }
                    }
                }
                .onStart {
                    Log.d("flowLog", "onStart")
                }
//                .flowOn(Dispatchers.IO)
                .onCompletion {
                    Log.d("flowLog", "onCompletion")
                }
                .catch {
                    // 错误处理
                    val err = ExceptionHandle.handleException(it)
                    Log.d("flowLog", "catch=${err.errMsg}")
                }
                .collect {
                    data.value = "code = " + it.errorCode
                    Log.d("flowLog", "collect=${it.errorMsg}")
                }
        }
    }


    fun getListData() {

        launchGo(
            {
                var testBean: TestBean = AppHttpMethods.instance.getTestData(0)
                val list = ArrayList<String>()
                for (index in 0..30) {
                    list.add("$index")
                }
                listData.value = list
            }
        )
    }


}