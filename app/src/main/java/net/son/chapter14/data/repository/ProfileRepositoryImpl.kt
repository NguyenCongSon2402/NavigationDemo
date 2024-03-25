package net.son.chapter14.data.repository

import kotlinx.coroutines.flow.Flow
import net.son.chapter14.data.dao.UserDao
import net.son.chapter14.data.model.User

class ProfileRepositoryImpl(
    private val userDao: UserDao
) : ProfileRepository {
    override fun login(email: String, password: String): Flow<User?> {
        return userDao.login(email, password)
    }

    override fun findUserById(id: Int): Flow<User?> {
        return userDao.findById(id)
    }
}