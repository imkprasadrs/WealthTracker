package com.wealthtracker.android.application.injection.module

import android.app.Application
import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module provide dependancies all over your application level
 * https://medium.com/@malinitin/setup-dagger-2-11-on-kotlin-project-2257ad84ad7c
 *
 * Dagger Steps 1: create Module, 2: Create Component, 3: Create Graph
 *
 * the below is an example of why we add repository interfaces in ApplicationComponent class
 * https://medium.com/@yostane/dependency-injection-with-dagger-2-inject-and-provides-ce21f7449ec5
 *  Created By Krishna Prasad
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(context: Context): FirebaseAnalytics =
        FirebaseAnalytics.getInstance(context)
}