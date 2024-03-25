package net.son.chapter14

import android.app.Application
import net.son.chapter14.data.database.AppDatabase
import net.son.chapter14.data.repository.ProfileRepositoryImpl

class MyApplication : Application() {
    private val database by lazy { AppDatabase.getDatabase(applicationContext) }
    val repository by lazy { ProfileRepositoryImpl(database.getUserDao()) }
}