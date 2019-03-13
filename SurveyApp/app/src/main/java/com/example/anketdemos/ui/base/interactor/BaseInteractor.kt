package com.sumeyye.projetakip.ui.base.interactor

import com.example.anketdemos.data.api.ApiHelper
import com.example.anketdemos.data.model.User
import com.sumeyye.projetakip.data.preferences.PreferenceHelper

open class BaseInteractor(var preferenceHelper: PreferenceHelper, var apiHelper: ApiHelper) : IBaseInteractor {

    override fun getCurrentUser(): User {
        val userId = this.preferenceHelper.getCurrentUserId().toString()
        val mail = this.preferenceHelper.getCurrentUserEmail().toString()
        val fullName = this.preferenceHelper.getCurrentUserName().toString()
        val registrationToken = this.preferenceHelper.getRegistrationToken().toString()
        val tokens= mutableListOf<String>()
        tokens.add(registrationToken)
        return User(userId, fullName, "")
    }

    override fun getUserId(): String =
            this.preferenceHelper.getCurrentUserId().toString()


    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() != true



}