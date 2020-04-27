package com.wealthtracker.android.presentation.startup.view

import android.os.Bundle
import com.wealthtracker.android.R
import com.wealthtracker.android.application.injection.component.ActivityComponent
import com.wealthtracker.android.presentation.base.BaseActivity
import com.wealthtracker.android.presentation.base.Presenter
import com.wealthtracker.android.presentation.startup.presenter.SplashPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashPresenter.Display, SplashPresenter.Router {

    @Inject
    override lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.pageOpened()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
        presenter.inject(this, this)
    }
}