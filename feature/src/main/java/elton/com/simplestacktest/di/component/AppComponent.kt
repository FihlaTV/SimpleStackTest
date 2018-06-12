package elton.com.simplestacktest.di.component

import android.app.Application
import dagger.Component
import elton.com.simplestacktest.di.module.AppModule
import javax.inject.Singleton

/**
 * Created by elton on 4/5/2018.
 **/
@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun getApplication(): Application

//    fun inject(app: BaseApplication)
}