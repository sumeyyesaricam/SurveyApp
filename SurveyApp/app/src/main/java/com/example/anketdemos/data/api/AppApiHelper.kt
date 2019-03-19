package com.example.anketdemos.data.api

import android.util.Log
import com.example.anketdemos.data.model.Survey
import com.example.anketdemos.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.iid.FirebaseInstanceId
import javax.inject.Inject

class AppApiHelper @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private var firestore: FirebaseFirestore
) : ApiHelper {
    override fun addSurvey(content: String, response: String, otherResponse: String, onComplete: (String) -> Unit) {
        val survey= Survey()
        val surveys = firestore.collection("survey").document()
        survey.questionId = surveys.id
        surveys.set(survey)
    }

    override fun signup(username: String, password: String, onComplete: (String) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = firebaseAuth.currentUser!!.uid
                    val token = FirebaseInstanceId.getInstance().token
                    val user = User(userId, username, token)
                    firestore.collection("user").document(userId).get().addOnSuccessListener { documentSnapshot ->
                        if (!documentSnapshot.exists()) {
                            firestore.collection("user").document(userId).set(user).addOnSuccessListener {
                                onComplete(userId)
                            }
                        } else
                            onComplete("")
                    }
                }
            }
    }

    override fun getQuestions(onListen: (List<Survey>) -> Unit): ListenerRegistration {
        val questionList = mutableListOf<Survey>()
        return firestore.collection("question")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e("FIRESTORE", "ChatMessagesListener error.", firebaseFirestoreException)
                } else {
                    querySnapshot?.documents?.forEach {
                        questionList.add(it.toObject(Survey::class.java)!!)
                    }
                }
                onListen(questionList)
            }
    }


}