package com.wealthtracker.android.domain.portfolio.usecase

import com.wealthtracker.android.domain.portfolio.PortfolioRepository
import com.wealthtracker.android.domain.portfolio.model.CompanyDetails
import io.reactivex.Single
import javax.inject.Inject

/**
 *  Created By Krishna Prasad
 */
class GetCompaniesBasedOnIndiaUseCase @Inject constructor(private val portfolioRepository: PortfolioRepository) {

    fun getCompaniesBasedOnKeyword(keyword: String): Single<List<CompanyDetails>> =
        portfolioRepository.getCompanyNames(keyword)
            .map {
                it.filter { it.currency == "INR" }
            }
}