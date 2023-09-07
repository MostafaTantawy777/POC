package com.tantawy.data.remote

import com.google.gson.annotations.SerializedName
import com.tantawy.data.remote.DataConstants.CODE
import com.tantawy.data.remote.DataConstants.MESSAGE
import com.tantawy.data.remote.DataConstants.PAYLOAD
import com.tantawy.data.remote.DataConstants.STATUS

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