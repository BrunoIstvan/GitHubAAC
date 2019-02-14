package br.com.bicmsystems.githubaac.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import br.com.bicmsystems.githubaac.data.UserRepository
import br.com.bicmsystems.githubaac.data.local.dao.UserDAO
import br.com.bicmsystems.githubaac.data.local.db.MyDatabase
import br.com.bicmsystems.githubaac.data.remote.UserWebservice
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module //(includes = [DatabaseModule::class])
class AppModule {

    @Provides
    fun provideExecutor() : Executor {

        return Executors.newSingleThreadExecutor()

    }


}