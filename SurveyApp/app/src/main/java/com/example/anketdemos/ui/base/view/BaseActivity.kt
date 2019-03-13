package com.sumeyye.projetakip.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.anketdemos.util.CommonUtil
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(),BaseView{

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }

    }
}