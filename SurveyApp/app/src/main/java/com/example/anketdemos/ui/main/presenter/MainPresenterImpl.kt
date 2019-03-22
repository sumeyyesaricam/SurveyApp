package com.example.anketdemos.ui.main.presenter

import com.example.anketdemos.data.model.Survey
import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.view.MainView
import com.example.anketdemos.util.AppConstants
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import java.util.ArrayList
import javax.inject.Inject

class MainPresenterImpl<V : MainView, I : MainInteractorImpl> @Inject internal constructor(interactor: I) :
    BasePresenter<V, I>(interactor = interactor),MainPresenter<V, I> {

    override fun onClickCreateSurvey(question: String,response: String,otherResponse: String) {
        getView()?.showProgress()
        val survey=Survey("",content = question,response = response,otherResponse = otherResponse)
        interactor?.createSurvey(survey) {
            getView()?.hideProgress()
        }
    }

    override fun setRecyclerSurveyList() {
        getView()?.showProgress()
        interactor?.getQuestions {surveyList->
            getView()?.hideProgress()
            getView()?.setSurveyListAdapter(surveyList)
        }
    }


}