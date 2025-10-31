package {{cookiecutter.package_name}}.di

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import {{ cookiecutter.package_name }}.utils.Constants


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @ApplicationScope
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    @Provides
    @Singleton
    fun provideCacheHeaders() : Interceptor {
        val interceptor = Interceptor { chain ->
            val originalChain = chain.proceed(chain.request())
            val isNetworkAvailable = false
            val maxAge = 60

            if (isNetworkAvailable) {
                originalChain.newBuilder().header("Cache-Control", "public, max-age=$maxAge").build()
            } else  {
                val maxStale = 60 * 60 * 24 * 28
                originalChain.newBuilder().header("Cache-Control", "public, max-age=$maxAge").build()
            }
        }
        return interceptor
    }

    fun buildUserAgent(): String {
        return "UserAgentString"
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(application: Application, interceptor: Interceptor): OkHttpClient {

        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(Interceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                    .header("User-Agent", buildUserAgent())
                chain.proceed(requestBuilder.build())
            })
            .addInterceptor(interceptor)
            .build()
        return client
    }


    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(stockClient: OkHttpClient, json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(stockClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }


}