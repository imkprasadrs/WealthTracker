package com.wealthtracker.android.presentation.startup.presenter

import com.wealthtracker.android.domain.analytics.AnalyticsRepository
import com.wealthtracker.android.presentation.base.Presenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val analyticsRepository: AnalyticsRepository) :
    Presenter() {

    private lateinit var display: Display
    private lateinit var router: Router

    // region Lifecycle
    public fun inject(display: Display, router: Router) {
        this.display = display
        this.router = router
    }
    // endregion

    // region public methods
    fun pageOpened() {
        analyticsRepository.logEvents("Splash Screen")
    }
    // endregion

    interface Display {

    }

    interface Router {

    }
}