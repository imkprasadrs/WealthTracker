package com.wealthtracker.android.data.portfolio

import com.wealthtracker.android.data.portfolio.model.Company
import com.wealthtracker.android.data.portfolio.model.StockPrice
import com.wealthtracker.android.domain.portfolio.model.CompanyDetails
import com.wealthtracker.android.domain.portfolio.model.StockPrice as DomainStockPrice

/**
 *  Created By Krishna Prasad
 */

// SEARCH tags
private const val COMPANY_SYMBOL_TAG = "1. symbol"
private const val COMPANY_NAME_TAG = "2. name"
private const val TYPE_TAG = "3. type"
private const val COMPANY_LISTED_COUNTRY_TAG = "4. region"
private const val CURRENCY_TAG = "8. currency"

private const val STOCK_EXCHANGE_NSE_VALUE = "India/NSE"
private const val STOCK_EXCHANGE_BSE_VALUE = "India/Bombay"
private const val CURRENCY__INR_VALUE = "INR"

// STOCKS TAG
private const val GLOBAL_QUOTE_TAG = "Global Quote"
private const val STOCK_PRICE_TAG = "05. price"

fun mapToCompanyDetails(companyNames: Company?): List<CompanyDetails> =
    companyNames?.let {
        it.bestMatches
            .map {
                CompanyDetails(
                    it.get(COMPANY_NAME_TAG).toString(),
                    it.get(COMPANY_SYMBOL_TAG).toString(),
                    it.get(COMPANY_LISTED_COUNTRY_TAG).toString(),
                    it.get(TYPE_TAG).toString(),
                    it.get(CURRENCY_TAG).toString()
                )
            }
    } ?: listOf()

fun mapToStockDetails(stockDetais: StockPrice): DomainStockPrice =
    stockDetais?.let {
        DomainStockPrice(it.GLOBAL_QUOTE_TAG.get(STOCK_PRICE_TAG).toString().toLong())
    }
