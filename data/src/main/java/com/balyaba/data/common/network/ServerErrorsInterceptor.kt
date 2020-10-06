package com.balyaba.data.common.network

import okhttp3.Interceptor
import okhttp3.Response

class ServerErrorsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response: Response?
        try {
            response = chain.proceed(request)
        } catch (e: Exception) {
            throw ServerError
        }

        return response
    }
}
