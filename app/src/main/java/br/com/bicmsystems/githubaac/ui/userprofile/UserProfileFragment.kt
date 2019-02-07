package br.com.bicmsystems.githubaac.ui.userprofile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bicmsystems.githubaac.data.local.entity.User
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        TODO("IMPLEMENTAR")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        this.configureDagger()
        this.configureViewModel()
        this.setupView()

    }

    private fun setupView() {

        TODO("IMPLEMENTAR")

        btnPesquisar.setOnClickListener {
            viewModel.pesquisar(edtUsername.text.toString())
            viewModel.user.observe(this, Observer {
                updateUI(it)
            })
        }

    }

    private fun configureDagger() {

        AndroidSupportInjection.inject(this)

    }

    private fun configureViewModel() {

        viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(UserProfileViewModel::class.java)

    }

    private fun updateUI(user: User?) {

        user?.let {

            TODO("IMPLEMENTAR")
            //Glide.with(activity.applicationContext).load(user.avatarURL).into(ivUsuario)
            //tvUsuario.text = user.login

        }

    }

}