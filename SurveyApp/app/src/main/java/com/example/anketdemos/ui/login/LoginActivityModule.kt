package com.example.anketdemos.ui.login

import com.example.anketdemos.ui.login.interactor.LoginInteractor
import com.example.anketdemos.ui.login.interactor.LoginInteractorImpl
import com.example.anketdemos.ui.login.presenter.LoginPresenter
import com.example.anketdemos.ui.login.presenter.LoginPresenterImpl
import com.example.anketdemos.ui.login.view.LoginView
import dagger.Module
import dagger.Provides


@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractorImpl): LoginInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenterImpl<LoginView, LoginInteractorImpl>)
            : LoginPresenter<LoginView, LoginInteractorImpl> = presenter
}