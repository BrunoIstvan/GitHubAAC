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

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : MyDatabase {

        return Room.databaseBuilder(application,
                MyDatabase::class.java, "MyDatabase.db")
                .build()

    }

    @Provides
    @Singleton
    fun provideUserDAO(database: MyDatabase) : UserDAO {

        return database.userDAO()

    }

    @Provides
    fun provideExecutor() : Executor {

        return Executors.newSingleThreadExecutor()

    }

    @Provides
    @Singleton
    fun provideUserRepository(
            webservice: UserWebservice,
            userDAO: UserDAO,
            executor: Executor) : UserRepository {

        return UserRepository(webservice, userDAO, executor)

    }

    @Provides
    @Singleton
    fun provideGson() : Gson {

        return GsonBuilder().create()

    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) : Retrofit {

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

    }

    @Provides
    @Singleton
    fun provideApiWebService(restAdapter: Retrofit) : UserWebservice {

        return restAdapter.create(UserWebservice::class.java)

    }

    companion object {

        private val BASE_URL = "https://api.github.com/"

    }

}