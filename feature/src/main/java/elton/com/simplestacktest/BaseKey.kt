package elton.com.simplestacktest

import android.os.Bundle
import android.os.Parcelable

/**
 * Created by Owner on 2017.11.13.
 */
abstract class BaseKey(open val tag: String) : Parcelable {
    val fragmentTag: String
        get() = toString()

    var argsBuilder: Bundle = Bundle()

    fun newFragment(argsBuilder: Bundle.() -> Unit = {}): BaseFragment {
        val fragment = createFragment().apply {
            arguments = (arguments ?: this@BaseKey.argsBuilder).also { bundle ->
                bundle.putParcelable("KEY", this@BaseKey)
                bundle.apply(argsBuilder)
            }
        }
        return fragment
    }

    protected abstract fun createFragment(): BaseFragment

    abstract fun stackIdentifier(): String

    fun withArgs(argsBuilder: Bundle.() -> Unit): BaseKey {
        this.argsBuilder.apply(argsBuilder)

        return this
    }

    companion object {
        val mTag: String get() = this::class.java.simpleName
    }

}