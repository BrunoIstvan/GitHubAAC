package br.com.bicmsystems.githubaac

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {

        super.onCreate()
        this.initDagger()

    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {

        return dispatchingAndroidInjector

    }

    private fun initDagger() {

        TODO("IMPLEMENTAR")

    }

}