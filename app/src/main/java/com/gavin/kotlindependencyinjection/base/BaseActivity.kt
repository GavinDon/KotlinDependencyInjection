package com.gavin.kotlindependencyinjection.base

import android.os.Bundle
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.gavin.kotlindependencyinjection.mvp.MvpCompanion
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.AndroidContextGetter
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein

/**
 * description:
 * Created by liNan on 2018/9/18 13:38

 */
abstract class BaseActivity : AppCompatActivity(), KodeinAware, MvpCompanion.MvpView {


    private lateinit var contextGetter: AndroidContextGetter

    //继承自application的kodein
    private val _parentKodein by closestKodein()

    override val kodeinTrigger = KodeinTrigger()


    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein, copy = Copy.All)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(layoutId)
        kodeinTrigger.trigger()
        initView(savedInstanceState)
    }


    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun initView(savedInstanceState: Bundle?)


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    /**
     * 获取ViewModel
     * 因为调用比较频繁,所以此处使用Inline函数
     */
    inline fun <reified T : BaseViewModel> getViewModel(): T {
        return ViewModelProviders.of(this)[T::class.java]
    }

}