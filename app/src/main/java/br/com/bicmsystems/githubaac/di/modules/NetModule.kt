package br.com.bicmsystems.githubaac.di.modules

import br.com.bicmsystems.githubaac.BuildConfig
import br.com.bicmsystems.githubaac.data.remote.UserWebservice
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideGson() : Gson {

        return GsonBuilder().create()

    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson,
                        @Named("githubURL") githubURL: String,
                        okHttp: OkHttpClient) : Retrofit {

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(githubURL)
                //.baseUrl(BuildConfig.GITHUB_URL)
                //.baseUrl(BASE_URL)
                .client(okHttp)
                .build()

    }

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {

        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

    }

    @Provides
    @Singleton
    @Named("githubURL")
    fun provideGithubURL() : String {
        return BuildConfig.GITHUB_URL
    }

    @Provides
    @Singleton
    fun provideApiWebService(restAdapter: Retrofit) : UserWebservice {
        return restAdapter.create(UserWebservice::class.java)
    }

    /*
    companion object {
        private val BASE_URL = "https://api.github.com/"
    }
    */

}