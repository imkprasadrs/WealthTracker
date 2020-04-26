package com.wealthtracker.android.domain.exception


/**
 *  Created By Krishna Prasad
 */
class HttpCallFailureException(error: Throwable) : NetworkException(error) {
}