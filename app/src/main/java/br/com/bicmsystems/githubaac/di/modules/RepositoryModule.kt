package br.com.bicmsystems.githubaac.di.modules

import br.com.bicmsystems.githubaac.data.UserRepository
import br.com.bicmsystems.githubaac.data.local.dao.UserDAO
import br.com.bicmsystems.githubaac.data.remote.UserWebservice
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module(includes = [
    NetModule::class,
    DatabaseModule::class,
    AppModule::class
])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
            webservice: UserWebservice,
            userDAO: UserDAO,
            executor: Executor) : UserRepository {

        return UserRepository(webservice, userDAO, executor)

    }

}