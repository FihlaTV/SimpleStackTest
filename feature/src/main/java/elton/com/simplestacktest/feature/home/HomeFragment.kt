package elton.com.simplestacktest.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.simplestack.BackstackDelegate
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.BaseKey
import elton.com.simplestacktest.FragmentStateChanger
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.feature.basic.BasicKey
import elton.com.simplestacktest.feature.dashboardblock.DashboardBlockKey
import elton.com.simplestacktest.feature.other.OtherKey
import elton.com.simplestacktest.utils.Multistack
import kotlinx.android.synthetic.main.frame_bottom_nav_view.*
import timber.log.Timber

/**
 * Created by elton on 16/04/2018.
 */

class HomeFragment: BaseFragment(), StateChanger {

    val test: String by lazy { arguments?.getString("TAG") ?: "NULL" }

    lateinit var backstackDelegate: BackstackDelegate
    lateinit var fragmentStateChanger: FragmentStateChanger

    lateinit var multistack: Multistack
    var currentStack: BackstackDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity.homeFragment = this
        multistack = Multistack()

        multistack.add(StackType.FIRST.name, BackstackDelegate())
        multistack.add(StackType.DASHBOARD.name, BackstackDelegate())
        multistack.add(StackType.NOTIFICATIONS.name, BackstackDelegate())


        multistack.onCreate(savedInstanceState)

        multistack.onCreate(StackType.FIRST.name, savedInstanceState, null, BasicKey())
        multistack.onCreate(StackType.DASHBOARD.name, savedInstanceState, null, DashboardBlockKey())
        multistack.onCreate(StackType.NOTIFICATIONS.name, savedInstanceState, null, OtherKey())

        currentStack = multistack[StackType.FIRST.name]

        Timber.i(test)

        super.onCreate(savedInstanceState)

        fragmentStateChanger = FragmentStateChanger(childFragmentManager, R.id.homeFrame)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frame_bottom_nav_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Control the navigation item.
//        multistack.setSelectedStack(StackType.DASHBOARD.name)
//        navigation.selectedItemId = R.id.navigation_dashboard

        navigation.setOnNavigationItemSelectedListener { menuItem ->
            multistack.setSelectedStack(menuItem.toString().toUpperCase())
            currentStack = multistack[(menuItem.toString().toUpperCase())]
            return@setOnNavigationItemSelectedListener true
        }

        multistack.setStateChanger(this)
    }

    override fun onResume() {
        super.onResume()
        multistack.onPostResume()
    }

    override fun onPause() {
        multistack.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        currentStack = null
        multistack.onDestroy()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        multistack.onSaveInstanceState(outState)
    }

    fun navigateTo(key: BaseKey) {
        multistack.navigateTo(key)
    }

    fun replaceHistory(key: BaseKey) {
        multistack.replaceHistory(key)
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.topNewState<Any>() == stateChange.topPreviousState<Any>()) {
            completionCallback.stateChangeComplete()
            return
        }

        if (stateChange.topPreviousState<Any>() == null) {
            fragmentStateChanger.changeBaseFragment(stateChange)
        } else {
            fragmentStateChanger.handleStateChange(stateChange)
        }

        completionCallback.stateChangeComplete()
    }

    companion object {
        enum class StackType {
            FIRST,
            DASHBOARD,
            NOTIFICATIONS
        }
    }
}