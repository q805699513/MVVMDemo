package com.longsh.mvvm.base

/**
 * @author LongShaoHua
 * @date 2018/8/15
 */
open class BaseBean {
    var errorCode: Int = -1
    var errorMsg: String? = ""

    val isOk: Boolean
        get() = this.errorCode == 0

    val isNotOnline: Boolean
        get() = this.errorCode == 600100

}
