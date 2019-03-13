package com.example.anketdemos.data.api

import android.util.Log
import com.example.anketdemos.data.model.Question
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.iid.FirebaseInstanceId
import javax.inject.Inject

class AppApiHelper @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private var firestore: FirebaseFirestore
) : ApiHelper {
    override fun onTokenRefresh(userId:String,onListen: (String) -> Unit) {
        val newRegistrationToken = FirebaseInstanceId.getInstance().token
         firestore.collection("user").document(userId).get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                firestore.collection("user").document(userId).update("registrationToken" , newRegistrationToken)
                onListen(newRegistrationToken.toString())
            } else
                onListen("")
        }
    }

    override fun signup(username: String, password: String, onComplete: (String) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userID = firebaseAuth.currentUser!!.uid
                    onComplete(userID)
                } else {
                    onComplete("")
                }
            }
    }


    override fun getQuestions(onListen: (List<Question>) -> Unit): ListenerRegistration {
        val questionList = mutableListOf<Question>()
        return firestore.collection("question")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e("FIRESTORE", "ChatMessagesListener error.", firebaseFirestoreException)
                } else {
                    querySnapshot?.documents?.forEach {
                        questionList.add(it.toObject(Question::class.java)!!)
                    }
                }
                onListen(questionList)
            }
    }


}