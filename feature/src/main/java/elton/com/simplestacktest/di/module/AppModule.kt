package elton.com.simplestacktest.di.module

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by elton on 4/5/2018.
 **/
@Module
class AppModule(internal var mApplication: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application = mApplication
}