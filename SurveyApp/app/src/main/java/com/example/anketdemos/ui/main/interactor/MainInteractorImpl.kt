package com.example.anketdemos.ui.main.interactor

import com.example.anketdemos.data.api.ApiHelper
import com.example.anketdemos.data.model.Survey
import com.sumeyye.projetakip.data.preferences.PreferenceHelper
import com.sumeyye.projetakip.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractorImpl @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) :
    BaseInteractor(preferenceHelper, apiHelper), MainInteractor {
    override fun createSurvey(survey: Survey, onComplete: (String) -> Unit) {
        apiHelper.addSurvey(survey) {
            onComplete(it)
        }
    }

    override fun getQuestions(onListen: (List<Survey>) -> Unit) {
        apiHelper.getQuestions { questionList ->
            onListen(questionList)
        }
    }

}