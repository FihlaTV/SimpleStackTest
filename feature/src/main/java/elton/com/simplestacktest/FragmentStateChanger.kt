package elton.com.simplestacktest

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.zhuinden.simplestack.StateChange

/**
 * Created by Owner on 2017.11.13.
 *
 * Modified by elton.
 */

class FragmentStateChanger(
        private val fragmentManager: FragmentManager,
        private val containerId: Int
) {
    fun handleStateChange(stateChange: StateChange) {
        val fragmentTransaction = fragmentManager.beginTransaction().apply {
            when (stateChange.direction) {
                StateChange.FORWARD -> {
                    setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_out, android.R.anim.fade_in)
                }
                StateChange.BACKWARD -> {
                    setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                }
            }
            val previousState = stateChange.getPreviousState<BaseKey>()
            val newState = stateChange.getNewState<BaseKey>()
            for (oldKey in previousState) {
                val fragment = fragmentManager.findFragmentByTag(oldKey.fragmentTag)
                if (fragment != null) {
                    if (!newState.contains(oldKey)) {
                        remove(fragment)
                    } else if (!fragment.isDetached) {
                        detach(fragment)
                    }
                }
            }
            for (newKey in newState) {
                var fragment: Fragment? = fragmentManager.findFragmentByTag(newKey.fragmentTag)
                if (newKey == stateChange.topNewState<Any>()) {
                    if (fragment != null) {
                        if (fragment.isDetached) {
                            attach(fragment)
                        }
                    } else {
                        fragment = newKey.newFragment()
                        add(containerId, fragment, newKey.fragmentTag)
                    }
                } else {
                    if (fragment != null && !fragment.isDetached) {
                        detach(fragment)
                    }
                }
            }
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    /**
     * Method to switch the fragment shown by changing the bottom navigation bar
     */
    fun changeBaseFragment(stateChange: StateChange) {
        val fragmentTransaction = fragmentManager.beginTransaction().apply {
            when (stateChange.direction) {
                StateChange.FORWARD -> {
                    setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_out, android.R.anim.fade_in)
                }
                StateChange.BACKWARD -> {
                    setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                }
            }
            val newState = stateChange.getNewState<BaseKey>()
            if (fragmentManager.fragments.lastOrNull() != null) {
                if (fragmentManager.fragments.lastOrNull() == fragmentManager.findFragmentByTag(newState.last().fragmentTag))
                    return
                remove(fragmentManager.fragments.lastOrNull())
            }
            for (newKey in newState) {
                var fragment: Fragment? = fragmentManager.findFragmentByTag(newKey.fragmentTag)
                if (newKey == stateChange.topNewState<Any>()) {
                    if (fragment != null) {
                        if (fragment.isDetached) {
                            attach(fragment)
                        }
                    } else {
                        fragment = newKey.newFragment()
                        add(containerId, fragment, newKey.fragmentTag)
                    }
                } else {
                    if (fragment != null && !fragment.isDetached) {
                        detach(fragment)
                    }
                }
            }
        }
        fragmentTransaction.commit()
    }
}