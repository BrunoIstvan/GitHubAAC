package br.com.bicmsystems.githubaac.data.remote

import br.com.bicmsystems.githubaac.data.local.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserWebservice {

    @GET("/users/{user}")
    fun getUser(@Path("user") user: String) : Call<User>

}