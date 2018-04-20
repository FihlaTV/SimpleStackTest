package elton.com.simplestacktest.feature.titlebarbasic

import android.annotation.SuppressLint
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.utils.keyName
import kotlinx.android.parcel.Parcelize

/**
 * Created by elton on 19/4/2018.
 **/

@SuppressLint("ParcelCreator")
@Parcelize
class TitleBarBasicKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(TitleBarBasicKey))

    override fun createFragment(): BaseFragment = TitleBarBasicFragment()

    override fun stackIdentifier(): String = ""

    companion object {}
}