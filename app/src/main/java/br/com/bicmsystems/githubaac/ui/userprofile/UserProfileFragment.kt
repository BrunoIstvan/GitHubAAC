package br.com.bicmsystems.githubaac.ui.userprofile


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bicmsystems.githubaac.R

import br.com.bicmsystems.githubaac.data.local.entity.User
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_user_profile.*
import javax.inject.Inject


class UserProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        this.configureDagger()
        this.configureViewModel()
        this.setupView()

    }

    private fun setupView() {

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

            Glide.with(activity!!).load(user.avatarURL).into(ivUsuario)
            tvUsuario.text = user.login

        }

    }

}
