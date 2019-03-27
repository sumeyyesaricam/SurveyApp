package com.example.anketdemos.ui.login.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.anketdemos.R
import com.example.anketdemos.ui.login.interactor.LoginInteractor
import com.example.anketdemos.ui.login.interactor.LoginInteractorImpl
import com.example.anketdemos.ui.login.presenter.LoginPresenter
import com.example.anketdemos.ui.main.view.MainActivity
import com.example.anketdemos.util.AppConstants
import com.example.anketdemos.util.CommonUtil
import com.sumeyye.projetakip.ui.base.view.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(),LoginView{

    @Inject
    internal lateinit var presenter: LoginPresenter<LoginView, LoginInteractorImpl>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setOnClickListeners()
        presenter.onAttach(this)
        presenter.isLogin()

    }

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            AppConstants.EMPTY_EMAIL_ERROR -> CommonUtil.showToastMessage(this,getString(R.string.empty_email_error_message))
            AppConstants.INVALID_EMAIL_ERROR ->CommonUtil.showToastMessage(this,getString(R.string.invalid_email_error_message))
            AppConstants.EMPTY_PASSWORD_ERROR -> CommonUtil.showToastMessage(this,getString(R.string.empty_password_error_message))
            AppConstants.LOGIN_FAILURE -> CommonUtil.showToastMessage(this,getString(R.string.login_failure))
        }
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun setOnClickListeners() {
        btn_login.setOnClickListener { presenter.onClickedLogin(et_username.text.toString(), et_password.text.toString()) }
    }
}
