package elton.com.simplestacktest.feature.home

import android.annotation.SuppressLint
import elton.com.simplestacktest.BaseFragment
import kotlinx.android.parcel.Parcelize
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.utils.keyName

/**
 * Created by elton on 16/04/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class HomeKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(HomeKey))

    override fun createFragment(): BaseFragment = HomeFragment()

    override fun stackIdentifier(): String = HomeFragment.Companion.StackType.FIRST.name

    companion object {}
}