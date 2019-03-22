package com.example.anketdemos.ui.login.presenter

import com.example.anketdemos.ui.login.interactor.LoginInteractorImpl
import com.example.anketdemos.ui.login.view.LoginView
import com.mindorks.framework.mvp.ui.base.presenter.IBasePresenter


interface LoginPresenter<V : LoginView, I : LoginInteractorImpl> :  IBasePresenter<V, I> {
    fun onClickedLogin(username: String, password: String)
}