package com.example.anketdemos.ui.login.presenter

import com.example.anketdemos.ui.login.interactor.LoginInteractorImpl
import com.example.anketdemos.ui.login.view.LoginView
import com.example.anketdemos.util.AppConstants
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenterImpl<V : LoginView, I : LoginInteractorImpl> @Inject internal constructor(interactor: I) :
    BasePresenter<V, I>(interactor = interactor),
    LoginPresenter<V, I> {

    override fun onClickedLogin(username: String, password: String) {
        when {
            username.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.doServerLoginApiCall(username = username, password = password) { userId ->
                    getView()?.hideProgress()
                    getView()?.showValidationMessage(AppConstants.LOGIN_FAILURE)

                }
            }
        }
    }
}