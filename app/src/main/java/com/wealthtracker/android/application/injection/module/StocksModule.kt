package com.wealthtracker.android.application.injection.module

import com.wealthtracker.android.data.account.PortfolioService
import com.wealthtracker.android.domain.portfolio.PortfolioRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 *  Created By Krishna Prasad
 */
@Module
class StocksModule {

    @Provides
    @Singleton
    fun providePortfolioRepository(
        @Named(RetrofitModule.NO_AUTH_RETROFIT) retrofit: Retrofit
    ): PortfolioRepository =
        PortfolioService(retrofit)
}