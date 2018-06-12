package elton.com.simplestacktest.di.component

import dagger.Component
import elton.com.simplestacktest.di.module.AppModule
import elton.com.simplestacktest.di.module.NetModule
import elton.com.simplestacktest.feature.MainActivity
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by elton on 12/6/2018.
 **/
@Singleton
@Component(modules = [ AppModule::class, NetModule::class ])
interface NetComponent {
    fun getRetrofit(): Retrofit

    fun inject(activity: MainActivity)
}