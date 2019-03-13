package com.example.anketdemos.ui.main.interactor

import com.example.anketdemos.data.api.ApiHelper
import com.example.anketdemos.data.model.Question
import com.sumeyye.projetakip.data.preferences.PreferenceHelper
import com.sumeyye.projetakip.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractorImpl @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) :
    BaseInteractor(preferenceHelper, apiHelper), MainInteractor {
    override fun getQuestions(onListen: (List<Question>) -> Unit) {
apiHelper.getQuestions { questionList->{

} }
    }

}