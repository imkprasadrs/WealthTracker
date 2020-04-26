package com.wealthtracker.android.application.injection.component

import com.wealthtracker.android.application.annotation.PerScreen
import com.wealthtracker.android.presentation.portfolio.view.DashboardActivity
import dagger.Component

/**
 *  Created By Krishna Prasad
 */
@PerScreen
@Component(dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    // Portfolio
    fun inject(activity: DashboardActivity)
}