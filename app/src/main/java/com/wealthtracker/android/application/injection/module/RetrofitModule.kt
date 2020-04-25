package com.cleanarchitecture.android.application.injection.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 *  Created By Krishna Prasad
 */
@Module
class RetrofitModule {
    companion object {
        const val NO_AUTH_RETROFIT = "NO_AUTH_RETROFIT"
        const val BASE_URL = "https://www.alphavantage.co/"
    }

    @Provides
    @Singleton
    @Named(NO_AUTH_RETROFIT)
    fun provideNoAuthRetrofit(
        @Named(NetworkModule.NO_AUTH_HTTP_CLIENT) httpClient: OkHttpClient,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit =
        retrofitBuilder
            .client(httpClient)
            .baseUrl(BASE_URL)
            .build()
}