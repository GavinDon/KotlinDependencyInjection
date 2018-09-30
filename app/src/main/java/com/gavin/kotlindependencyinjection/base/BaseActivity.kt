package com.gavin.kotlindependencyinjection.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.gavin.kotlindependencyinjection.mvp.MvpCompanion
import com.gavin.kotlindependencyinjection.ui.test
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.AndroidContextGetter
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import java.util.*

/**
 * description:
 * Created by liNan on 2018/9/18 13:38

 */
abstract class BaseActivity : AppCompatActivity(), KodeinAware,MvpCompanion.MvpView, Observer {


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
        kodeinTrigger.trigger()
    }
    @test
    fun abc(){

    }

}