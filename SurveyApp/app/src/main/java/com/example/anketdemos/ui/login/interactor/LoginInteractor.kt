package com.example.anketdemos.ui.login.interactor

interface LoginInteractor {
    fun doServerLoginApiCall(username: String, password: String, onComplete: (String) -> Unit)
    fun onTokenRefresh()
    fun isLogin(onComplete: (Boolean) -> Unit)
    fun setLogin()
}