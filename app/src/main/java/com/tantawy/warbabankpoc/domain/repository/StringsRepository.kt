package com.tantawy.warbabankpoc.domain.repository

import com.tantawy.warbabankpoc.R
import com.tantawy.warbabankpoc.data.AppResources

class StringsRepository(private val appResources: AppResources) {

    fun getNetworkExceptionMessage(): String = appResources.getString(R.string.check_your_network_connection_and_try_again)

    fun getUnknownErrorMessage(): String = appResources.getString(R.string.unknown_error_message)

    fun getSocketTimeoutExceptionMessage(): String = appResources.getString(R.string.timeout_error_message)

}