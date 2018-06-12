package elton.com.simplestacktest.di.module

import com.google.gson.*
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by elton on 4/5/2018.
 **/
@Module
class NetModule
(val mBaseUrl: String){

     @Provides
     @Singleton
     internal fun provideGson(): Gson {
         val gsonBuilder = GsonBuilder()
         //        gsonBuilder.excludeFieldsWithModifiers(Modifier.TRANSIENT)
         gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                 .setExclusionStrategies(object: ExclusionStrategy {
                     override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                         return false
                     }

                     override fun shouldSkipField(f: FieldAttributes?): Boolean {
                         return false
                         //                        return f!!.declaredClass == RealmObject::class.java
                     }
                 })
         return gsonBuilder.create()
     }

     @Provides
     @Singleton
     internal fun provideOkHttpClient(): OkHttpClient {
         /**
          * Add header Connection: close
          * for PUT and POST method
          */
         val okHttpClient = OkHttpClient.Builder()
                 .addNetworkInterceptor(object : Interceptor {
                     override fun intercept(chain: Interceptor.Chain?): Response {
                         val request = chain!!.request()
                                 .newBuilder().addHeader("Connection", "close").build()
                         return chain.proceed(request)
                     }
                 })
         return okHttpClient.build()
     }

     @Provides
     @Singleton
     internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
         val retrofit = Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .baseUrl(mBaseUrl)
                 .client(okHttpClient)
                 .build()
         return retrofit
     }
}