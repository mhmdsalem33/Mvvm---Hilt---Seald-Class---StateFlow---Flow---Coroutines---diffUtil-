package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.di

import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.NewWork.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("url")
    fun provideUrl()  = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesApiService(@Named("url") url :String) : ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}