package com.wealthtracker.android.presentation.portfolio.view

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cleanarchitecture.android.application.injection.component.ActivityComponent
import com.cleanarchitecture.android.presentation.base.BaseActivity
import com.cleanarchitecture.android.presentation.portfolio.presenter.DashboardPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.wealthtracker.android.R
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
        setContentView(R.layout.activity_main)

        presenter.getCompanyNames("tata")
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
        presenter.inject(this, this)
    }
}
