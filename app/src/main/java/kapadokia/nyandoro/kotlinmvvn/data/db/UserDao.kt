package kapadokia.nyandoro.kotlinmvvn.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kapadokia.nyandoro.kotlinmvvn.data.db.entities.CURRENT_USER_ID
import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User
import kotlinx.coroutines.selects.select

// this interface is a data access object
@Dao
interface UserDao {

    // because it is an insert operation we will use an insert annotation and define the conflict strategy
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun upsert(user : User): Long

    // function to give us back the stored user
    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<User>

}