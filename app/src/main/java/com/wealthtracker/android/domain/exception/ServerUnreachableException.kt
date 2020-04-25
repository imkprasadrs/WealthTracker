package com.cleanarchitecture.android.domain.exception

/**
 *  Created By Krishna Prasad
 */
class ServerUnreachableException(error: Throwable): NetworkException(error){
}