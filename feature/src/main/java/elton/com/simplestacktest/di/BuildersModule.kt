package elton.com.simplestacktest.di

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.dashboardblock.DashboardBlockFragment
import javax.inject.Singleton

/**
 * Created by elton on 4/5/2018.
 **/
/*
@Module(subcomponents = [
    MainActivityComponent::class
])
*/
@Module
abstract class BuildersModule {

/*
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
*/
    @ContributesAndroidInjector(modules = [NetModule::class])
    @Singleton
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [NetModule::class])
    @Singleton
    abstract fun bindDashboardBlockFragment(): DashboardBlockFragment
}