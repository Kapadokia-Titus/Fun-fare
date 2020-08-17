package kapadokia.nyandoro.kotlinmvvn.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    // a companion object to create the app's database
    companion object{

        @Volatile // this means that this variable is immediately visible to all the other threads
        private var instance :AppDatabase? = null
        private val LOCK = Any() // makes sure that we do not create two instances of our database

        // pass context to an invoke operator, we need context to create database
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }




}