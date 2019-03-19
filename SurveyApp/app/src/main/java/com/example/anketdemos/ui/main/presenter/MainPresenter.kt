package com.example.anketdemos.ui.main.presenter

import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.view.MainView


interface MainPresenter<V : MainView, I : MainInteractorImpl> {
    fun addQuestionClicked(title:String)
}