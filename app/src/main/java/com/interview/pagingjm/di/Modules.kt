package com.interview.pagingjm.di

import com.google.gson.GsonBuilder
import com.interview.pagingjm.BuildConfig
import com.interview.pagingjm.network.api.Api
import com.interview.pagingjm.network.datasource.CloudRedditDataSource
import com.interview.pagingjm.network.datasource.RedditDataSource
import com.interview.pagingjm.network.reddit.paging.PostPagingDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Modules {

    fun getApiModule() = module {
        val client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            client.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }

        single<Api> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(
                    client.build()
                )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create((Api::class.java))
        }
    }

    fun getCloudModule() = module {
        factory<RedditDataSource> {
            CloudRedditDataSource(
                api = get()
            )
        }
    }

    val postPagingDataSourceModule = module {
        scope<PostPagingDataSource> {
            scoped(qualifier = named(Scopes.CLOUD_DATA_SOURCE)) {
                PostPagingDataSource(get())
            }
        }
    }
}