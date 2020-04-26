package com.wealthtracker.android.application.injection.component

import com.wealthtracker.android.application.annotation.PerScreen
import com.wealthtracker.android.presentation.portfolio.view.DashboardActivity
import com.wealthtracker.android.presentation.startup.view.SplashActivity
import dagger.Component

/**
 *  Created By Krishna Prasad
 */
@PerScreen
@Component(dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(activity: DashboardActivity)
    fun inject(activity: SplashActivity)
}