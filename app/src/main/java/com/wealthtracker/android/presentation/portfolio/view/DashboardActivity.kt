package com.wealthtracker.android.presentation.portfolio.view

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.wealthtracker.android.R
import com.wealthtracker.android.application.injection.component.ActivityComponent
import com.wealthtracker.android.presentation.base.BaseActivity
import com.wealthtracker.android.presentation.portfolio.presenter.DashboardPresenter
import javax.inject.Inject

/**
 *  Created By Krishna Prasad
 */
class DashboardActivity : BaseActivity(), DashboardPresenter.Display, DashboardPresenter.Router {

    private lateinit var appBarConfiguration: AppBarConfiguration

    @Inject
    override lateinit var presenter: DashboardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.getCompanyNames("tata")
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
        presenter.inject(this, this)
    }
}
