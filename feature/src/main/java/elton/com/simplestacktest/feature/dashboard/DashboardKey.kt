package elton.com.simplestacktest.feature.dashboard

import android.annotation.SuppressLint
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.feature.home.HomeFragment
import elton.com.simplestacktest.utils.keyName
import kotlinx.android.parcel.Parcelize

/**
 * Created by elton on 16/04/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class DashboardKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(DashboardKey))

    override fun createFragment(): BaseFragment = DashboardFragment()

    override fun stackIdentifier(): String = HomeFragment.Companion.StackType.DASHBOARD.name

    companion object {}
}