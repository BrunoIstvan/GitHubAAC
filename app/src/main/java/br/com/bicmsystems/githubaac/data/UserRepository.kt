package br.com.bicmsystems.githubaac.data

import android.arch.lifecycle.LiveData
import br.com.bicmsystems.githubaac.data.local.dao.UserDAO
import br.com.bicmsystems.githubaac.data.local.entity.User
import br.com.bicmsystems.githubaac.data.remote.UserWebservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject

constructor(private val webservice: UserWebservice,
            private val userDAO: UserDAO,
            private val executor: Executor) {

    fun getUser(userLogin: String) : LiveData<User> {

        refreshUser(userLogin)

        return userDAO.load(userLogin)

    }

    fun refreshUser(userLogin: String) {

        executor.execute {

            val userExists = userDAO.hasUser(userLogin, getMaxRefreshTime(Date())) != null

            if(!userExists) {

                webservice.getUser(userLogin)
                        .enqueue(object : Callback<User> {

                            override fun onFailure(call: Call<User>?, t: Throwable?) { }

                            override fun onResponse(call: Call<User>?, response: Response<User>?) {

                                executor.execute {

                                    val user = response?.body()
                                    user?.lastRefresh = Date()

                                    user?.let { userDAO.save(it) }

                                }

                            }

                        })

            }

        }

    }

    private fun getMaxRefreshTime(currentDate: Date): Date {

        val cal = Calendar.getInstance()
        cal.time = currentDate
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES)
        return cal.time

    }

    companion object {
        private const val FRESH_TIMEOUT_IN_MINUTES = 3
    }

}