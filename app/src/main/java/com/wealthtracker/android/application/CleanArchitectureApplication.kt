package com.cleanarchitecture.android.data.account

import android.app.Application
import com.cleanarchitecture.android.application.injection.component.ApplicationComponent
import com.cleanarchitecture.android.application.injection.component.DaggerApplicationComponent
import com.cleanarchitecture.android.application.injection.module.ApplicationModule

class CleanArchitectureApplication : Application() {

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