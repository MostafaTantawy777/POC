package com.tantawy.warbabankpoc.data.remote

import com.google.gson.annotations.SerializedName
import com.tantawy.warbabankpoc.data.DataConstants.CODE
import com.tantawy.warbabankpoc.data.DataConstants.MESSAGE
import com.tantawy.warbabankpoc.data.DataConstants.PAYLOAD
import com.tantawy.warbabankpoc.data.DataConstants.STATUS

private const val SUCCESS_STATUS = "1"

data class APIResponse<P>(
    @SerializedName(STATUS) var status: String,
    @SerializedName(CODE) var code: String,
    @SerializedName(MESSAGE) var message: String,
    @SerializedName(PAYLOAD) var payload: P?
) {

    fun isSuccessful(): Boolean {
        return status == SUCCESS_STATUS
    }
}