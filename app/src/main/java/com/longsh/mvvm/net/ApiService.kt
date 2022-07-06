package com.longsh.mvvm.net


import com.longsh.mvvm.model.TestBean
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * @author LongShaoHua
 * @date 2018/7/29
 */
interface ApiService {

    @GET("user_article/list/{curPage}/json")
    suspend fun getTestData(@Path("curPage") curPage: Int): TestBean

}

