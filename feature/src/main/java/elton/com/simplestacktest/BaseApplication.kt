package elton.com.simplestacktest

import android.app.Application
import elton.com.simplestacktest.di.component.AppComponent
import elton.com.simplestacktest.di.module.AppModule
import elton.com.simplestacktest.di.component.DaggerAppComponent
import elton.com.simplestacktest.di.component.DaggerNetComponent
import elton.com.simplestacktest.di.component.NetComponent
import elton.com.simplestacktest.di.module.NetModule
import timber.log.Timber

/**
 * Created by elton on 16/04/2018.
 */

open class BaseApplication: Application() {

    companion object {
        lateinit var mAppModule: AppModule
        lateinit var mNetModule: NetModule

        lateinit var mAppComponent: AppComponent
        lateinit var mNetComponent: NetComponent
    }

    override fun onCreate() {
        super.onCreate()

        createComponent()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    open fun createComponent() {
        mAppModule = AppModule(this)

        mAppComponent = DaggerAppComponent.builder()
                .appModule(mAppModule)
                .build()

        mNetModule = NetModule("https://github.com")

        mNetComponent = DaggerNetComponent.builder()
                .appModule(mAppModule)
                .netModule(mNetModule)
                .build()
    }
}