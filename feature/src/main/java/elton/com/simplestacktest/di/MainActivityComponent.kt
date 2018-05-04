package elton.com.simplestacktest.di

import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import elton.com.simplestacktest.feature.MainActivity
import javax.inject.Named

/**
 * Created by elton on 4/5/2018.
 **/
@Subcomponent(modules = [
    NetModule::class
])
interface MainActivityComponent: AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>()
}