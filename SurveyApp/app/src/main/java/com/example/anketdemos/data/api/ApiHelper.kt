package com.example.anketdemos.data.api

import com.example.anketdemos.data.model.Survey
import com.google.firebase.firestore.ListenerRegistration

interface ApiHelper {

    fun getQuestions(onListen: (List<Survey>) -> Unit): ListenerRegistration

    fun signup(username: String, password: String,onComplete: (String) -> Unit)

    fun addSurvey(content: String, response: String, otherResponse: String,onComplete: (String) -> Unit)

}