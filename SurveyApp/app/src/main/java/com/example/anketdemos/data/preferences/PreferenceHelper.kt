package com.sumeyye.projetakip.data.preferences


interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Boolean

    fun setCurrentUserLoggedInMode(mode: Boolean)

    fun getCurrentUserId(): String?

    fun setCurrentUserId(userId: String?)

    fun getCurrentUserName(): String?

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(email: String?)

    fun getRegistrationToken(): String?

    fun setRegistrationToken(token: String?)



}