package br.com.bicmsystems.githubaac.di.modules

import br.com.bicmsystems.githubaac.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

}