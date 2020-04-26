package com.wealthtracker.android.data.account

import android.app.Application
import com.wealthtracker.android.application.injection.component.ApplicationComponent
import com.wealthtracker.android.application.injection.component.DaggerApplicationComponent
import com.wealthtracker.android.application.injection.module.ApplicationModule

class WealthTrackerApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent =
            DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        applicationComponent.inject(this)
    }
}