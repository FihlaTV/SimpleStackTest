package elton.com.simplestacktest.utils

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment
import android.view.View;
import com.zhuinden.simplestack.*

import elton.com.simplestacktest.BaseKey

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Zhuinden on 2017.02.19..
 */

class Multistack {
    private val backstackDelegates = LinkedHashMap<String, BackstackDelegate>()
    private var selectedStack: String? = null
    private var stateChanger: StateChanger? = null

    private var isPaused = false

    fun add(identifier: String, backstackDelegate: BackstackDelegate): BackstackDelegate {
        if (selectedStack == null) {
            selectedStack = identifier
        }
        backstackDelegates[identifier] = backstackDelegate
        backstackDelegate.setPersistenceTag(identifier)
        return backstackDelegate
    }

    operator fun get(identifier: String?): BackstackDelegate? {
        return backstackDelegates.get(identifier)
    }

    fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            selectedStack = savedInstanceState.getString("selectedStack")
        }
    }

    fun onCreate(identifier: String, savedInstanceState: Bundle?, nonConfigurationInstance: NonConfigurationInstance?, key: Parcelable) {
        get(identifier)?.onCreate(savedInstanceState,
                nonConfigurationInstance?.getNonConfigInstance(identifier),
                History.single(key))
    }

    fun onSaveInstanceState(outState: Bundle) {
        outState.putString("selectedStack", selectedStack)
        for (backstackDelegate in backstackDelegates.values) {
            backstackDelegate.onSaveInstanceState(outState)
        }
    }

    fun onRetainCustomNonConfigurationInstance(): Any {
        val nonConfigurationInstance = NonConfigurationInstance()
        for (entry in backstackDelegates) {
            nonConfigurationInstance.putNonConfigInstance(entry.key, entry.value.onRetainCustomNonConfigurationInstance())
        }
        return nonConfigurationInstance
    }

    fun setStateChanger(stateChanger: StateChanger?) {
        this.stateChanger = stateChanger
        for (entry in backstackDelegates) {
            if (!entry.key.equals(selectedStack)) {
                entry.value.onPause() // FIXME maybe this should be exposed better.
            } else {
                entry.value.setStateChanger(stateChanger)
            }
        }
    }

    fun onPostResume() {
        isPaused = false
        for (entry in backstackDelegates) {
            if (!entry.key.equals(selectedStack)) {
                entry.value.onPause() // FIXME maybe this should be exposed better.
            } else {
                entry.value.onPostResume()
            }
        }
    }

    fun onPause() {
        isPaused = true
        for (entry in backstackDelegates) {
            entry.value.onPause()
        }
    }

    fun onBackPressed(): Boolean {
        val result = get(selectedStack)?.onBackPressed() ?: false
        return result
    }

    fun onDestroy() {
        for (entry in backstackDelegates) {
            entry.value.onDestroy()
        }
    }

    fun setSelectedStack(identifier: String) {
        if (!backstackDelegates.containsKey(identifier)) {
            throw IllegalArgumentException("You cannot specify a stack [$identifier] that does not exist!")
        }
        if (selectedStack != identifier) {
            this.selectedStack = identifier
            setStateChanger(stateChanger)
        }
    }

    class NonConfigurationInstance {
        internal var nonConfigInstances: MutableMap<String, BackstackDelegate.NonConfigurationInstance> = HashMap()

        fun getNonConfigInstance(key: String): BackstackDelegate.NonConfigurationInstance? {
            return nonConfigInstances[key]
        }

        fun putNonConfigInstance(key: String, nonConfigurationInstance: BackstackDelegate.NonConfigurationInstance) {
            nonConfigInstances[key] = nonConfigurationInstance
        }
    }

    fun persistViewToState(view: View?, baseFragment: Fragment? = null) {
        if (view != null) {
            val key = Backstack.getKey<BaseKey>(view.getContext())
            if (baseFragment != null) {

            }

            val backstackDelegate = this[key.stackIdentifier()]
            backstackDelegate?.persistViewToState(view)
//            val backstackDelegate = key.selectDelegate(view.getContext())
//            backstackDelegate.persistViewToState(view)
        }
    }

    fun restoreViewFromState(view: View) {
        val key = Backstack.getKey<BaseKey>(view.getContext())
//        val backstackDelegate = key.selectDelegate(view.getContext())
//        backstackDelegate.restoreViewFromState(view)
    }
}