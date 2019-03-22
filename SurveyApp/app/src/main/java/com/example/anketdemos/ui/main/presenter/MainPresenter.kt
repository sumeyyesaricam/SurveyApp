package com.example.anketdemos.ui.main.presenter

import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.view.MainView
import com.mindorks.framework.mvp.ui.base.presenter.IBasePresenter


interface MainPresenter<V : MainView, I : MainInteractorImpl> : IBasePresenter<V, I> {
    fun onClickCreateSurvey(question: String,response: String,otherResponse: String)

    fun setRecyclerSurveyList()
}