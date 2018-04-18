package elton.com.simplestacktest

import android.os.Bundle
import android.os.Parcelable

/**
 * Created by Owner on 2017.11.13.
 */
abstract class BaseKey(open val tag: String) : Parcelable {
    val fragmentTag: String
        get() = toString()

    fun newFragment(): BaseFragment {
        val fragment = createFragment().apply {
            arguments = (arguments ?: Bundle()).also { bundle ->
                bundle.putParcelable("KEY", this@BaseKey)
            }
        }
        return fragment
    }

    protected abstract fun createFragment(): BaseFragment

    abstract fun stackIdentifier(): String

    companion object {
        val mTag: String get() = this::class.java.simpleName
    }

}