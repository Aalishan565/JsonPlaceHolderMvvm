package com.example.jsonplaceholdermvvm.di.network

import com.example.jsonplaceholdermvvm.service.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Aalishan Ansari on 03/01/23.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(basUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(basUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesPostApiService(retrofit: Retrofit): PostService {
        return retrofit.create(PostService::class.java)
    }

}