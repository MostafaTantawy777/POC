package com.tantawy.warbabankpoc.data.exceptions

import java.io.IOException

class APIException(var code: String, override var message: String) : IOException()