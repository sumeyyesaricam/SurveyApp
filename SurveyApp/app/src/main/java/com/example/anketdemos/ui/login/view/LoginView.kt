package com.example.anketdemos.ui.login.view

import com.sumeyye.projetakip.ui.base.view.BaseView

interface LoginView:BaseView{
    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}