package kapadokia.nyandoro.kotlinmvvn.ui.home.quotes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel;
import kapadokia.nyandoro.kotlinmvvn.data.repositories.QuotesRepository
import kapadokia.nyandoro.kotlinmvvn.util.lazyDeferred

@RequiresApi(Build.VERSION_CODES.O)
class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
