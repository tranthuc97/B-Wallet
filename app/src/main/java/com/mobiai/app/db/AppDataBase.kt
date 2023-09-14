package com.mobiai.app.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobiai.app.App
import com.mobiai.app.db.notes.Note
import com.mobiai.app.db.notes.NoteDao
import com.mobiai.app.db.password.Password
import com.mobiai.app.db.password.PasswordDao
import com.mobiai.app.db.question.Question
import com.mobiai.app.db.question.QuestionDao

@Database(entities = [Note::class,Password::class,Question::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun passWordDao() : PasswordDao
    abstract fun questionDao() : QuestionDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabaseClient(): AppDataBase {
            if (INSTANCE != null) return INSTANCE!!

            synchronized(this){
                INSTANCE = Room
                    .databaseBuilder(
                        App.getInstance().applicationContext ,
                        AppDataBase::class.java,
                        "AppDataBase").
                    fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!
            }
        }
    }
}