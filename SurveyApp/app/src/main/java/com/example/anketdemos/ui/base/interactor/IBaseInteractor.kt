package com.sumeyye.projetakip.ui.base.interactor

import com.example.anketdemos.data.model.User


interface IBaseInteractor {

    fun isUserLoggedIn(): Boolean

    fun getUserId(): String

    fun getCurrentUser(): User

}