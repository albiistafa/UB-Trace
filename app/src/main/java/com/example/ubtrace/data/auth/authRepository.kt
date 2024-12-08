package com.example.ubtrace.data.auth

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class authRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    suspend fun login(email: String, password: String): Result<String?>{
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Result.success(result.user?.uid)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
    suspend fun register(email: String, password: String): Result<String?> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            Result.success(result.user?.uid)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    fun logout(){
        auth.signOut()
    }
    fun getCurrentUser(): String?{
        return auth.currentUser?.uid
    }
}

