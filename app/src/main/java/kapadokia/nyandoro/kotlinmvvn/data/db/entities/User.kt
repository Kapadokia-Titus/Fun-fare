package kapadokia.nyandoro.kotlinmvvn.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

// constants
const val CURRENT_USER_ID=0      // TO ALLOW ONLY THE AUTHENTICATED USER TO BE STORED

// this class in an entity to our room database
@Entity
data class User(
    var id:Int? = null,
    var name: String? =null,
    var email: String? =null,
    var password: String? =null,
    var email_verified_at: String? =null,
    var created_at: String? =null,
    var updated_at: String? =null
){

    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}