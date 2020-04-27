package com.wealthtracker.android.data.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.wealthtracker.android.domain.analytics.AnalyticsRepository

/**
 * Created By Krishna Prasad
 */
class AnalyticsService(firebaseAnalytics: FirebaseAnalytics) : AnalyticsRepository {

    private companion object {
        const val PARAM_LABEL = "label"
        const val SCREEN_NAME_EVENT = "screen_name"
    }

    private val firebaseAnalytics = firebaseAnalytics

    override fun logEvents(screenName: String) {
        val bundle = Bundle()
        bundle.putString(PARAM_LABEL, screenName)
        firebaseAnalytics.logEvent(SCREEN_NAME_EVENT, bundle)
    }
}