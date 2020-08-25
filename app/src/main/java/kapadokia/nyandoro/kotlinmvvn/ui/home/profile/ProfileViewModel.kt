package kapadokia.nyandoro.kotlinmvvn.ui.home.profile

import androidx.lifecycle.ViewModel;
import kapadokia.nyandoro.kotlinmvvn.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
