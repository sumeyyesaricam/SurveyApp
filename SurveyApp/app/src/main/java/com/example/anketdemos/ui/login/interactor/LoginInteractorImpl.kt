package com.example.anketdemos.ui.login.interactor

import com.example.anketdemos.data.api.ApiHelper
import com.sumeyye.projetakip.data.preferences.PreferenceHelper
import com.sumeyye.projetakip.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class LoginInteractorImpl @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) :
    BaseInteractor(preferenceHelper, apiHelper), LoginInteractor {
    override fun doServerLoginApiCall(username: String, password: String, onComplete: (String) -> Unit) {
        apiHelper.signup(username, password) { userId ->
            onComplete(userId)
        }
    }

    override fun onTokenRefresh() {

    }
}