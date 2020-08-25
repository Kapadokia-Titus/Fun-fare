package kapadokia.nyandoro.kotlinmvvn


import android.app.Application
import kapadokia.nyandoro.kotlinmvvn.data.db.AppDatabase
import kapadokia.nyandoro.kotlinmvvn.data.network.MyApi
import kapadokia.nyandoro.kotlinmvvn.data.network.NetworkConnectionInterceptor
import kapadokia.nyandoro.kotlinmvvn.data.preferences.PreferenceProvider
import kapadokia.nyandoro.kotlinmvvn.data.repositories.QuotesRepository
import kapadokia.nyandoro.kotlinmvvn.data.repositories.UserRepository
import kapadokia.nyandoro.kotlinmvvn.ui.auth.AuthViewModelFactory
import kapadokia.nyandoro.kotlinmvvn.ui.home.profile.ProfileViewModelFactory
import kapadokia.nyandoro.kotlinmvvn.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider{ QuotesViewModelFactory(instance())}


    }

}