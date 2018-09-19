package com.gavin.kotlindependencyinjection.mvp.presenter

import android.content.Context
import android.content.Intent
import com.gavin.kotlindependencyinjection.mvp.contact.MainContact
import com.gavin.kotlindependencyinjection.ui.Main2Activity
import com.gavin.kotlindependencyinjection.ui.MainActivity
import org.kodein.di.KodeinContext
import org.kodein.di.android.AndroidContextGetter

/**
 * description:
 * Created by liNan on 2018/9/19 16:47

 */
class MainPresenter : MainContact.Presenter {
    private lateinit var mView: MainContact.View

    private lateinit var kodeinContext: KodeinContext<Context>

    private lateinit var contextGetter: AndroidContextGetter

    override fun attachView(view: MainContact.View) {
        this.mView = view
    }

    override fun showData() {
        print("showdata")
        val a = (mView as MainActivity)
        val intent = Intent(a, Main2Activity::class.java)
        a.startActivity(intent)

    }


}