package elton.com.simplestacktest.feature.titlebarlist

import android.annotation.SuppressLint
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.utils.keyName
import kotlinx.android.parcel.Parcelize

/**
 * Created by elton on 23/4/2018.
 **/
@SuppressLint("ParcelCreator")
@Parcelize
class TitleBarListKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(TitleBarListKey))

    override fun createFragment(): BaseFragment = TitleBarListFragment()

    override fun stackIdentifier(): String = ""

    companion object {}
}