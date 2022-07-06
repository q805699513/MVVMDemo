package com.longsh.mvvm.net

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @author LongShaoHua
 * @date 2018/7/29
 */
class RetrofitServiceManager private constructor() {

    companion object {
        private const val DEFAULT_TIME_OUT = 15
        private const val DEFAULT_READ_TIME_OUT = 15
        private const val DEFAULT_WRITE_TIME_OUT = 15

        private const val BASE_URL = "https://www.wanandroid.com/"

        val instance by lazy { SingletonHolder.INSTANCE }
    }

    private val mRetrofit: Retrofit

    init {
        val logging = HttpLoggingInterceptor { message -> Log.d("RetrofitLog", message + "") }
        logging.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
            .addInterceptor(logging)
//            .addInterceptor(SignInterceptor())
            //连接超时时间
            .connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
            //读操作超时时间
            .readTimeout(DEFAULT_READ_TIME_OUT.toLong(), TimeUnit.SECONDS)
            //写操作超时时间;
            .writeTimeout(
                DEFAULT_WRITE_TIME_OUT.toLong(),
                TimeUnit.SECONDS
            )

        // 创建Retrofit
        mRetrofit = Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            //使用rxJava
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            //基础地址;
            .baseUrl(BASE_URL)
            .build()
    }

    private object SingletonHolder {
        val INSTANCE = RetrofitServiceManager()
    }

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }

}
