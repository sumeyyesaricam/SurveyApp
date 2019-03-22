package com.example.anketdemos.ui.main.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.anketdemos.R
import com.example.anketdemos.data.model.Survey
import com.example.anketdemos.ui.main.interactor.MainInteractor
import com.example.anketdemos.ui.main.interactor.MainInteractorImpl
import com.example.anketdemos.ui.main.presenter.MainPresenter
import com.example.anketdemos.util.AppConstants
import com.example.anketdemos.util.CommonUtil
import com.sumeyye.projetakip.ui.base.view.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_create_survey.view.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    internal lateinit var presenter: MainPresenter<MainView, MainInteractorImpl>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
    }

    private fun setUp() {
        presenter.onAttach(this)
        setOnClickListeners()
        presenter.setRecyclerSurveyList()
    }

    private fun setOnClickListeners() {
        fab_create.setOnClickListener { onClickCreateSurvey() }
    }

    override fun onClickCreateSurvey() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("Anket Oluştur")
        val dialogLayout = inflater.inflate(R.layout.dialog_create_survey, null)
        val et_question = dialogLayout.et_question
        val et_response = dialogLayout.et_response
        val et_other_response = dialogLayout.et_other_response
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
            presenter.onClickCreateSurvey(
                et_question.text.toString(),
                et_response.text.toString(),
                et_other_response.text.toString()
            )
        }
        builder.show()
    }

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            AppConstants.LOAD_SURVEY_LIST_ERROR -> CommonUtil.showToastMessage(
                this,
                getString(R.string.load_survey_list_error)
            )
            AppConstants.ADD_SURVEY_ERROR -> CommonUtil.showToastMessage(this, getString(R.string.add_survey_error))

        }
    }

    override fun setSurveyListAdapter(surveys: List<Survey>) {
        recycler_question.layoutManager = LinearLayoutManager(this)
        recycler_question.adapter = SurveyAdapter(surveys)
    }

}
