package alison.fivethingskotlin.ViewModels


import alison.fivethingskotlin.API.repository.FiveThingsRepository
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import net.openid.appauth.AuthState
import net.openid.appauth.AuthorizationService

class FiveThingsViewModelFactory(private val repository: FiveThingsRepository, private val authState: AuthState?, private val authorizationService: AuthorizationService) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FiveThingsViewModel(repository, authState, authorizationService) as T
    }
}