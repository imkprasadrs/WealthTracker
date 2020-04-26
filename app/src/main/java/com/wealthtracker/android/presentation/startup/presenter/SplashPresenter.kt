package com.wealthtracker.android.presentation.startup.presenter

import com.wealthtracker.android.presentation.base.Presenter
import javax.inject.Inject

class SplashPresenter @Inject constructor() : Presenter() {

    private lateinit var display: Display
    private lateinit var router: Router

    // region Lifecycle
    public fun inject(display: Display, router: Router) {
        this.display = display
        this.router = router
    }

    interface Display {

    }

    interface Router {

    }
}