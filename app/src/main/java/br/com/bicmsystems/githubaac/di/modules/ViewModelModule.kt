package br.com.bicmsystems.githubaac.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.bicmsystems.githubaac.di.key.ViewModelKey
import br.com.bicmsystems.githubaac.ui.userprofile.UserProfileViewModel
import br.com.bicmsystems.githubaac.util.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserProfileViewModel(repoViewModel: UserProfileViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel) : ViewModelProvider.Factory

}