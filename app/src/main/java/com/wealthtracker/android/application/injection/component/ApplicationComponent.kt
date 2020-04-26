package com.wealthtracker.android.application.injection.component

import com.wealthtracker.android.application.injection.module.ApplicationModule
import com.wealthtracker.android.application.injection.module.NetworkModule
import com.wealthtracker.android.application.injection.module.RetrofitModule
import com.wealthtracker.android.application.injection.module.StocksModule
import com.wealthtracker.android.data.account.WealthTrackerApplication
import com.wealthtracker.android.domain.portfolio.PortfolioRepository
import dagger.Component
import javax.inject.Singleton


/**
 *  Created By Krishna Prasad
 */
@Singleton
@Component(
    modules = arrayOf(
        ApplicationModule::class, NetworkModule::class, RetrofitModule::class, StocksModule::class
    )
)
interface ApplicationComponent {
    fun inject(application: WealthTrackerApplication)

    fun getPortfolioRepo(): PortfolioRepository
}
