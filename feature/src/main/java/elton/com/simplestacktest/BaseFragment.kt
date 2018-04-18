package elton.com.simplestacktest

import android.support.v4.app.Fragment
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.utils.requireArguments

/**
 * Created by Owner on 2017.11.13.
 */

open class BaseFragment : Fragment() {
    val mainActivity: MainActivity by lazy { activity as MainActivity }

    fun <T : BaseKey> getKey(): T = requireArguments.getParcelable<T>("KEY")
}