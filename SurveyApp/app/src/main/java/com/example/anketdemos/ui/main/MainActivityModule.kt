package com.example.anketdemos.ui.main

import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.presenter.MainPresenter
import com.example.anketdemos.ui.main.presenter.MainPresenterImpl
import com.example.anketdemos.ui.main.view.MainView
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(interactor: MainInteractorImpl): MainInteractor = interactor

    @Provides
    internal fun provideMainPresenter(presenter: MainPresenterImpl<MainView, MainInteractor>)
            : MainPresenter<MainView, MainInteractor> = presenter
}