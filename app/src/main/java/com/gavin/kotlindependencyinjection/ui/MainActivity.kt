package com.gavin.kotlindependencyinjection.ui

import android.os.Bundle
import com.gavin.kotlindependencyinjection.R
import com.gavin.kotlindependencyinjection.base.BaseActivity
import com.gavin.kotlindependencyinjection.mvp.contact.MainContact
import com.gavin.kotlindependencyinjection.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance

class MainActivity : BaseActivity(),MainContact.View {


    private val mPresenter: MainPresenter by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(mPresenter)
        mPresenter.attachView(this)
        btn_start.setOnClickListener {
            mPresenter.showData()
        }
    }


}
