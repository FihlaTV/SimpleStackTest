package elton.com.simplestacktest.feature.other

import android.annotation.SuppressLint
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.feature.home.HomeFragment
import elton.com.simplestacktest.utils.keyName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class OtherKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(OtherKey))

    override fun createFragment(): BaseFragment = OtherFragment()

    override fun stackIdentifier(): String = HomeFragment.Companion.StackType.DASHBOARD.name

    companion object {}
}