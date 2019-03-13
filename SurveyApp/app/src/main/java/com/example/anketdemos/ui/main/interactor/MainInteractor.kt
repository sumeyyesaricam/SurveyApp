package com.example.anketdemos.ui.main.interactor

import com.example.anketdemos.data.model.Question

interface MainInteractor {
   fun getQuestions(onListen: (List<Question>) -> Unit)
}