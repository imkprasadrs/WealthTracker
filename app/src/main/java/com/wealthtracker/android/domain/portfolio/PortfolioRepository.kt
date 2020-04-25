package com.cleanarchitecture.android.domain.portfolio

import com.cleanarchitecture.android.domain.portfolio.model.CompanyDetails
import com.cleanarchitecture.android.domain.portfolio.model.StockPrice
import io.reactivex.Single

interface PortfolioRepository {
    fun getCompanyNames(keyword: String): Single<List<CompanyDetails>>
    fun getStockPrice(stockCode: String): Single<StockPrice>
}