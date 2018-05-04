package elton.com.simplestacktest.feature.titlebargridlist

import android.annotation.SuppressLint
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.utils.keyName
import kotlinx.android.parcel.Parcelize

/**
 * Created by elton on 16/04/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class TitleBarGridListKey(override val tag: String) : BaseKey(tag) {
    constructor() : this(keyName(TitleBarGridListKey))

    override fun createFragment(): BaseFragment = TitleBarGridListFragment()

    override fun stackIdentifier(): String = ""

    companion object {}
}