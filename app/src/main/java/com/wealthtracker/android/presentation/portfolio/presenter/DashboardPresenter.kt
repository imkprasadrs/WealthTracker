package com.wealthtracker.android.presentation.portfolio.presenter

import com.wealthtracker.android.application.annotation.PresenterObservable
import com.wealthtracker.android.application.annotation.PresenterSubscription
import com.wealthtracker.android.application.annotation.SubscribeOnResume
import com.wealthtracker.android.domain.portfolio.model.CompanyDetails
import com.wealthtracker.android.domain.portfolio.usecase.GetCompaniesBasedOnIndiaUseCase
import com.wealthtracker.android.presentation.base.Presenter
import io.reactivex.Single
import io.reactivex.disposables.Disposables
import javax.inject.Inject

/**
 *  Created By Krishna Prasad
 */
class DashboardPresenter @Inject constructor(private val getCompaniesBasedOnIndiaUseCase: GetCompaniesBasedOnIndiaUseCase) :
    Presenter() {

    private lateinit var display: Display
    private lateinit var router: Router

    @PresenterObservable
    private var companyNamesObservable: Single<List<CompanyDetails>>? = null

    @PresenterSubscription
    private var companyNamesSubscription = Disposables.disposed()

    // region Lifecycle
    public fun inject(display: Display, router: Router) {
        this.display = display
        this.router = router
    }
    // endregion

    // region Public methods
    // endregion

    // region Private methods
    fun getCompanyNames(keyword: String) {
        companyNamesObservable = getCompaniesBasedOnIndiaUseCase.getCompaniesBasedOnKeyword(keyword)
            .doOnSubscribe { }
            .doAfterTerminate {

            }

        subscribeToCompanyNames()
    }

    @SubscribeOnResume
    private fun subscribeToCompanyNames() {
        companyNamesObservable?.let {
            companyNamesSubscription.dispose()
            companyNamesSubscription = it.subscribe(
                {
                    it

                }, {
                    it
                })
        }

    }
    // endregion

    interface Display {

    }

    interface Router {

    }
}