package com.pancake.tictactoe.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseFirestoreService @Inject constructor(
    private val fireStore: FirebaseFirestore
) {

}