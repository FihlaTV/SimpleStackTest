package elton.com.simplestacktest.feature.basic

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
data class BasicKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(BasicKey))

    override fun createFragment(): BaseFragment = BasicFragment()

    override fun stackIdentifier(): String = ""

    companion object {}
}