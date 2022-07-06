package com.longsh.mvvm.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


/**
 * @author LongShaoHua
 * @date 20-7-14
 */
abstract class BaseActivity<VM : BaseViewModel, VDB : ViewDataBinding> : AppCompatActivity() {

    lateinit var dataBinding: VDB
    lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        View.GONE
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        // ViewModel 类
        val type = javaClass.genericSuperclass as ParameterizedType
        val modelClass = type.actualTypeArguments[0] as Class<VM>
        vm = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(modelClass)
        // vm 关联 lifecycle
        lifecycle.addObserver(vm)
        /** 注意: DataBinding 需调用 dataBinding.lifecycleOwner = this ,
        这样绑定了 LiveData 数据源的 xml 控件才会随着数据变化而改变。**/
        dataBinding.lifecycleOwner = this

        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

}