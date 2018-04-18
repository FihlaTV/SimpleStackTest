package elton.com.simplestacktest

import android.app.Application
import timber.log.Timber

/**
 * Created by elton on 16/04/2018.
 */

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}