package br.com.bicmsystems.githubaac

import android.app.Activity
import android.app.Application
import br.com.bicmsystems.githubaac.di.components.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {

        super.onCreate()
        this.initDagger()

        Stetho.initializeWithDefaults(this)

    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {

        return dispatchingAndroidInjector

    }

    private fun initDagger() {

        /* //TODO("IMPLEMENTAR") */
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

}