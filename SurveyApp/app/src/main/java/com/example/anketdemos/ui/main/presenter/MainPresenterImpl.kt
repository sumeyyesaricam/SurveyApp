package com.example.anketdemos.ui.main.presenter

import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.view.MainView
import javax.inject.Inject

class MainPresenterImpl<V : MainView, I : MainInteractorImpl> @Inject internal constructor(interactor: I) :
    MainPresenter<V, I> {
    override fun addQuestionClicked(title: String) {

    }

}