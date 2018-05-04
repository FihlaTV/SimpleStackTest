package elton.com.simplestacktest.di

import android.app.Application
import dagger.Binds
import dagger.Module

/**
 * Created by elton on 4/5/2018.
 **/
@Module
abstract class AppModule {

    @Binds
    abstract fun provideApplication(application: Application): Application
}