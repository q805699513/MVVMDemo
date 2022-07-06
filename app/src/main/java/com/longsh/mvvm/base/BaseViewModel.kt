package com.longsh.mvvm.base

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longsh.mvvm.net.exception.ExceptionHandle
import com.longsh.mvvm.net.exception.ResponseThrowable
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author LongShaoHua
 * @date 20-7-14
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

     fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch { block() }

    /**
     * 用流的方式进行网络请求
     */
    fun <T> launchFlow(block: suspend () -> T): Flow<T> {
        return flow {
            emit(block())
        }
    }

    fun launchGo(
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit = {
            Log.d("errorLog",it.errMsg)
        },
        complete: suspend CoroutineScope.() -> Unit = {}
    ) {
        launchUI {
            handleException(
                withContext(Dispatchers.IO) { block },
                { error(it) },
                { complete() }
            )
        }
    }

    /**
     * 异常统一处理
     */
    private suspend fun handleException(
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit = {},
        complete: suspend CoroutineScope.() -> Unit = {}
    ) {
        coroutineScope {
            try {
                block()
            } catch (e: Throwable) {
                error(ExceptionHandle.handleException(e))
            } finally {
                complete()
            }
        }
    }

}