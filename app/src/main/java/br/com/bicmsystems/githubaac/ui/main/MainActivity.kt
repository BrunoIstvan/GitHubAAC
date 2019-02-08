package br.com.bicmsystems.githubaac.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.bicmsystems.githubaac.R
import br.com.bicmsystems.githubaac.ui.userprofile.UserProfileFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.configureDagger()
        this.showFragment(savedInstanceState)

    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {

        return dispatchingAndroidInjector

    }

    private fun showFragment(savedInstanceState: Bundle?) {

        if(savedInstanceState == null) {

            val fragment = UserProfileFragment()
            /*//TODO("IMPLEMENTAR")*/

            supportFragmentManager.beginTransaction()
                    .add( R.id.container, fragment, null)
                    .commit()

        }

    }

    private fun configureDagger() {

        AndroidInjection.inject(this)

    }

}
