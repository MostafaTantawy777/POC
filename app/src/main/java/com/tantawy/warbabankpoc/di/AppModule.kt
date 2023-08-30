package com.tantawy.warbabankpoc.di

import com.tantawy.warbabankpoc.data.AppResources
import com.tantawy.warbabankpoc.di.DIConstants.KEY_GLIDE_OKHTTP_CLIENT
import com.tantawy.warbabankpoc.domain.repository.StringsRepository
import okhttp3.OkHttpClient
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

val applicationModule = module {

    single { AppResources(get()) }

    single { StringsRepository(get()) }

    single(StringQualifier(KEY_GLIDE_OKHTTP_CLIENT)) {
        OkHttpClient.Builder()
            .sslSocketFactory(
                get<SSLContext>().socketFactory,
                get<Array<TrustManager>>()[0] as X509TrustManager
            )
            .hostnameVerifier(get())
            .build()
    }
}