package com.cleanarchitecture.android.data.account

import com.cleanarchitecture.android.data.portfolio.mapToCompanyDetails
import com.cleanarchitecture.android.data.portfolio.mapToStockDetails
import com.cleanarchitecture.android.data.portfolio.model.Company
import com.cleanarchitecture.android.data.portfolio.model.StockPrice
import com.cleanarchitecture.android.domain.exception.HttpCallFailureException
import com.cleanarchitecture.android.domain.exception.NoNetworkException
import com.cleanarchitecture.android.domain.exception.ServerUnreachableException
import com.cleanarchitecture.android.domain.portfolio.PortfolioRepository
import com.cleanarchitecture.android.domain.portfolio.model.CompanyDetails
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import com.cleanarchitecture.android.domain.portfolio.model.StockPrice as DomainStockPrice

class PortfolioService(val retrofit: Retrofit) : PortfolioRepository {

    private val portfolioClient = retrofit.create(PortfolioClient::class.java)

    override fun getStockPrice(stockCode: String): Single<DomainStockPrice> =
        portfolioClient.getStockPrice(stockCode)
            .map {
                mapToStockDetails(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .mapNetworkErrors()

    override fun getCompanyNames(keyword: String): Single<List<CompanyDetails>> =
        portfolioClient.getCompanyNames(keyword)
            .map {
                mapToCompanyDetails(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .mapNetworkErrors()

    fun <T> Single<T>.mapNetworkErrors(): Single<T> =
        this.onErrorResumeNext { error ->
            when (error) {
                is SocketTimeoutException -> Single.error(NoNetworkException(error))
                is UnknownHostException -> Single.error(ServerUnreachableException(error))
                is HttpException -> Single.error(HttpCallFailureException(error))
                else -> Single.error(error)
            }
        }

    private interface PortfolioClient {
        @GET("query?function=SYMBOL_SEARCH&apikey=86M2HM34H8X15TXU")
        fun getCompanyNames(
            @Query("keywords") keyword: String
        ): Single<Company>

        @GET("query?function=GLOBAL_QUOTE&apikey=86M2HM34H8X15TXU")
        fun getStockPrice(@Query("symbol") stockCode: String): Single<StockPrice>
    }
}