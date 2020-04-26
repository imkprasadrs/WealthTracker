package com.wealthtracker.android.presentation.base

import com.wealthtracker.android.application.annotation.PresenterObservable
import com.wealthtracker.android.application.annotation.PresenterSubscription
import com.wealthtracker.android.application.annotation.SubscribeOnResume
import io.reactivex.disposables.Disposable
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 *  Created By Krishna Prasad
 */
abstract class Presenter {

    private var subscriptions: List<Field> = listOf()
    private var observables: List<Field> = listOf()
    private var methodToResume: List<Method> = listOf()

    fun onStart() {
        addSubscriptions()
        addMethodToResume()
        addObservables()

        start()
    }

    fun onResume() {
        methodToResume.forEach {
            it.isAccessible = true
            it.invoke(this) // this helps to call the function which is annotated "SubscribeToResume"
        }

        resume()
    }

    fun onPause() {
        subscriptions.forEach {
            it.isAccessible = true
            (it.get(this) as? Disposable)?.dispose()
        }

        pause()
    }

    fun onStop() {
        observables.forEach {
            it.isAccessible = true
            it.set(this, null)
        }

        stop()
    }

    protected open fun start() {}
    protected open fun resume() {}
    protected open fun pause() {}
    protected open fun stop() {}

    // region private methods
    private fun addSubscriptions() {
        subscriptions = listOfNotNull(javaClass.declaredFields.filter {
            it.isAnnotationPresent(PresenterSubscription::class.java)
        }, javaClass.superclass?.declaredFields?.filter {
            it.isAnnotationPresent(PresenterSubscription::class.java)
        })
            .flatten()
    }

    private fun addObservables() {
        observables = listOfNotNull(javaClass.declaredFields.filter {
            it.isAnnotationPresent(PresenterObservable::class.java)
        }, javaClass.superclass?.declaredFields?.filter {
            it.isAnnotationPresent(PresenterObservable::class.java)
        })
            .flatten()
    }

    private fun addMethodToResume() {
        methodToResume = listOfNotNull(javaClass.declaredMethods.filter {
            it.isAnnotationPresent(SubscribeOnResume::class.java)
        }, javaClass.superclass?.declaredMethods?.filter {
            it.isAnnotationPresent(SubscribeOnResume::class.java)
        })
            .flatten()
    }
    // endregion
}