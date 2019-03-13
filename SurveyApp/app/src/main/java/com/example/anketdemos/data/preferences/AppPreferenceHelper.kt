package com.sumeyye.projetakip.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.sumeyye.projetakip.di.scope.PreferenceInfo
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String) : PreferenceHelper {
    override fun getRegistrationToken(): String?  = mPrefs.getString(PREF_KEY_USER_REGISTRATION_TOKEN, "")

    override fun setRegistrationToken(token: String?) {
        mPrefs.edit().putString(PREF_KEY_USER_REGISTRATION_TOKEN, token).apply()
    }


    companion object {
        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private const val PREF_KEY_USER_REGISTRATION_TOKEN = "PREF_KEY_USER_REGISTRATION_TOKEN"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode(): Boolean = mPrefs.getBoolean(PREF_KEY_USER_LOGGED_IN_MODE, false)

    override fun setCurrentUserLoggedInMode(mode: Boolean) {
        mPrefs.edit().putBoolean(PREF_KEY_USER_LOGGED_IN_MODE, mode).apply()

    }

    override fun getCurrentUserId(): String? = mPrefs.getString(PREF_KEY_CURRENT_USER_ID, "")

    override fun setCurrentUserId(userId: String?) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply()
    }

    override fun getCurrentUserName(): String? = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "abc")

    override fun setCurrentUserName(userName: String?) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply()
    }

    override fun getCurrentUserEmail(): String? = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, "abc@gmail.com")

    override fun setCurrentUserEmail(email: String?) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply()
    }
}