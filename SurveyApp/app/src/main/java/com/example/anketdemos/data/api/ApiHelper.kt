package com.example.anketdemos.data.api

import com.example.anketdemos.data.model.Question
import com.google.firebase.firestore.ListenerRegistration
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface ApiHelper {

    fun getQuestions(onListen: (List<Question>) -> Unit): ListenerRegistration

    fun signup(username: String, password: String,onComplete: (String) -> Unit)

    fun onTokenRefresh(userId:String,onListen: (String) -> Unit)
}