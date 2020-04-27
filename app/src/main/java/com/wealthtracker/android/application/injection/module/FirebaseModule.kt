package com.wealthtracker.android.application.injection.module

import com.google.firebase.analytics.FirebaseAnalytics
import com.wealthtracker.android.data.analytics.AnalyticsService
import com.wealthtracker.android.domain.analytics.AnalyticsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created By Krishna Prasad
 */
@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideAnalyticsRepository(firebaseAnalytics: FirebaseAnalytics): AnalyticsRepository =
        AnalyticsService(firebaseAnalytics)
}