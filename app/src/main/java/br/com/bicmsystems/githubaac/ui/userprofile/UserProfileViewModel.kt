package br.com.bicmsystems.githubaac.ui.userprofile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.bicmsystems.githubaac.data.UserRepository
import br.com.bicmsystems.githubaac.data.local.entity.User
import javax.inject.Inject

class UserProfileViewModel @Inject
constructor(private val userRepository: UserRepository) : ViewModel() {

    var user: LiveData<User> = MutableLiveData<User>()

    fun pesquisar(userId: String) {

        user = userRepository.getUser(userId)

    }

}
