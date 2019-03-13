package com.example.anketdemos.ui.login.presenter

import com.example.anketdemos.ui.login.interactor.LoginInteractor
import com.example.anketdemos.ui.login.view.LoginView


interface LoginPresenter<V : LoginView, I : LoginInteractor> {
    fun onClickedLogin(username: String, password: String)
}