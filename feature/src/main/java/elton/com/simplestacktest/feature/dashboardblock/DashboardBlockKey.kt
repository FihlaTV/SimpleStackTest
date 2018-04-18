package elton.com.simplestacktest.feature.dashboardblock

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
data class DashboardBlockKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(DashboardBlockKey))

    override fun createFragment(): BaseFragment = DashboardBlockFragment()

    override fun stackIdentifier(): String = HomeFragment.Companion.StackType.DASHBOARD.name

    companion object {}
}