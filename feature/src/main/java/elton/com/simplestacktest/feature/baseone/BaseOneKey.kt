package elton.com.simplestacktest.feature.baseone

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
class BaseOneKey(override val tag: String): BaseKey(tag) {
    constructor() : this(keyName(BaseOneKey))

    override fun createFragment(): BaseFragment = BaseOneFragment()

    override fun stackIdentifier(): String = ""

    companion object {}
}