package com.example.anketdemos.ui.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.anketdemos.R
import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.presenter.MainPresenter
import com.sumeyye.projetakip.ui.base.view.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity(),MainView{

    @Inject
    internal lateinit var presenter: MainPresenter<MainView, MainInteractorImpl>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }
}
