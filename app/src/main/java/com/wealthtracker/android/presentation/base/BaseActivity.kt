package com.wealthtracker.android.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wealthtracker.android.application.injection.component.ActivityComponent
import com.wealthtracker.android.application.injection.component.DaggerActivityComponent
import com.wealthtracker.android.data.account.WealthTrackerApplication

/**
 *  Created By Krishna Prasad
 */
abstract class BaseActivity : AppCompatActivity() {

    protected abstract val presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityComponent = DaggerActivityComponent.builder()
            .applicationComponent(WealthTrackerApplication.applicationComponent)
            .build()

        inject(activityComponent)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        presenter.onStop()
        super.onDestroy()
    }

    protected abstract fun inject(activityComponent: ActivityComponent)
}