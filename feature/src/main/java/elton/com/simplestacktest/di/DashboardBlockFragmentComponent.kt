package elton.com.simplestacktest.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import elton.com.simplestacktest.feature.dashboardblock.DashboardBlockFragment

/**
 * Created by elton on 4/5/2018.
 **/
@Subcomponent(modules = [
    NetModule::class
])
interface DashboardBlockFragmentComponent: AndroidInjector<DashboardBlockFragment> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<DashboardBlockFragment>()
}