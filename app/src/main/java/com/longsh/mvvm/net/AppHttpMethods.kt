package com.longsh.mvvm.net

import com.longsh.mvvm.model.TestBean


/**
 * @author LongShaoHua
 * @date 2018/7/29
 */
class AppHttpMethods {
    private val httpMethods: ApiService =
        RetrofitServiceManager.instance.create(ApiService::class.java)

    private object SingletonHolder {
        val INSTANCE = AppHttpMethods()
    }

    companion object {
        val instance by lazy { SingletonHolder.INSTANCE }
    }

    suspend fun getTestData(curPage: Int): TestBean {
        return httpMethods.getTestData(curPage)
    }

}

