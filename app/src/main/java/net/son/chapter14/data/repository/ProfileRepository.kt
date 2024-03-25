package net.son.chapter14.data.repository

import kotlinx.coroutines.flow.Flow
import net.son.chapter14.data.model.User

interface ProfileRepository {
    fun login(email: String, password: String): Flow<User?>
    fun findUserById(id: Int): Flow<User?>
}