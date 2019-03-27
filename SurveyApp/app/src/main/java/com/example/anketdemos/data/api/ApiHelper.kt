package com.example.anketdemos.data.api

import com.example.anketdemos.data.model.Survey
import com.google.firebase.firestore.ListenerRegistration

interface ApiHelper {

    fun getSurveys(onComplete: (List<Survey>) -> Unit): ListenerRegistration

    fun signup(username: String, password: String,onComplete: (String) -> Unit)

    fun addSurvey(survey: Survey,onComplete: (String) -> Unit)

}