package com.example.anketdemos.ui.main.presenter

import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.view.MainView


interface MainPresenter<V : MainView, I : MainInteractor> {
    fun addQuestionClicked(title:String)
}