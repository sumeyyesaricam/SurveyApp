package com.example.anketdemos.ui.main.interactor

import com.example.anketdemos.data.model.Survey

interface MainInteractor {
   fun getQuestions(onListen: (List<Survey>) -> Unit)
   fun createSurvey(survey: Survey, onComplete: (String) -> Unit)
}