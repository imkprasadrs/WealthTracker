package com.wealthtracker.android.application.injection.module

import com.wealthtracker.android.BuildConfig
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


/**
 *  Created By Krishna Prasad
 */
@Module
class NetworkModule {
    companion object {
        const val NO_AUTH_HTTP_CLIENT = "NO_AUTH_OKHTTP"
        const val API_KEY = "apikey"
        const val DEFAULT_HTTP_TIMEOUT_SECOND = 30L
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @Singleton
    @Named(NO_AUTH_HTTP_CLIENT)
    fun provideNoAuthOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            connectTimeout(DEFAULT_HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
            readTimeout(DEFAULT_HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
        }.build()
}
