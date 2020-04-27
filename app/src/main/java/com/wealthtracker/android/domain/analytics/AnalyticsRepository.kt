package com.wealthtracker.android.domain.analytics

/**
 * Created By Krishna Prasad
 */
interface AnalyticsRepository {
    fun logEvents(screenName: String)
}