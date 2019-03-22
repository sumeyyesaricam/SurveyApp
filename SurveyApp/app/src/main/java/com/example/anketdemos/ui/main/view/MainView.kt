package com.example.anketdemos.ui.main.view

import com.example.anketdemos.data.model.Survey
import com.sumeyye.projetakip.ui.base.view.BaseView

interface MainView: BaseView {

    fun onClickCreateSurvey()
    fun showValidationMessage(errorCode: Int)
    fun setSurveyListAdapter(surveys: List<Survey>)
}