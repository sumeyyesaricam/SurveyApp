package com.example.anketdemos.util

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.example.anketdemos.R

object CommonUtil{
    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            //it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }
    fun showToastMessage(context: Context?, message:String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}