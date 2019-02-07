package br.com.bicmsystems.githubaac.di.modules

import br.com.bicmsystems.githubaac.ui.userprofile.UserProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeUserProfileFragment() : UserProfileFragment

}
