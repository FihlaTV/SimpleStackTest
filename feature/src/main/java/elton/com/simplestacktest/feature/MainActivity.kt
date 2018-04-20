package elton.com.simplestacktest.feature

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.test.espresso.idling.CountingIdlingResource
import com.zhuinden.simplestack.BackstackDelegate
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import elton.com.simplestacktest.*
import elton.com.simplestacktest.feature.baseone.BaseOneKey
import elton.com.simplestacktest.feature.home.HomeFragment
import elton.com.simplestacktest.feature.home.HomeKey
import elton.com.simplestacktest.utils.keyName

/**
 * Created by elton on 16/04/2018.
 */

class MainActivity : AppCompatActivity(), StateChanger {

    lateinit var backstackDelegate: BackstackDelegate
    lateinit var fragmentStateChanger: FragmentStateChanger

    var homeFragment: HomeFragment? = null

    // Provide the idling resource for Espresso test case
    val idlingResource = CountingIdlingResource("MAIN_ACTIVITY")

    override fun onCreate(savedInstanceState: Bundle?) {
        if (BuildConfig.DEBUG)
            idlingResource.increment()

        backstackDelegate = BackstackDelegate(null)
        backstackDelegate.onCreate(
                savedInstanceState,
                lastCustomNonConfigurationInstance,
//                History.from(mutableListOf(BaseOneKey(), HomeKey()))
                History.single(BaseOneKey())
        )

        backstackDelegate.registerForLifecycleCallbacks(this)

        super.onCreate(savedInstanceState)
        // homeFragment variable is initialized after HomeFragment is initialized.
        setContentView(R.layout.activity_main)

        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.base_frame)
        backstackDelegate.setStateChanger(this)

//        homeFragment = backstackDelegate.backstack.getHistory<BaseKey>().find { it.tag == keyName(HomeKey) }?.fragmentInstance as HomeFragment

        if (BuildConfig.DEBUG)
            idlingResource.decrement()
    }

    override fun onBackPressed() {
        val backStackTag = backstackDelegate.backstack.getHistory<BaseKey>().last()
        if (backStackTag.tag == keyName(HomeKey)) {
            val homeFragment = supportFragmentManager.findFragmentByTag(backStackTag.toString()) as HomeFragment
            if (!(homeFragment.multistack.onBackPressed())) {
                if (!backstackDelegate.onBackPressed()) {
                    super.onBackPressed()
                }
            }
        }
        else if (!backstackDelegate.onBackPressed()) {
            super.onBackPressed()
        }

    }

    fun replaceHistory(rootKey: BaseKey) {
        backstackDelegate.backstack.setHistory(History.single(rootKey), StateChange.REPLACE)
    }

    fun navigateTo(key: BaseKey) {
        backstackDelegate.backstack.goTo(key)
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.topNewState<Any>() == stateChange.topPreviousState<Any>()) {
            completionCallback.stateChangeComplete()
            return
        }
        fragmentStateChanger.handleStateChange(stateChange)
        completionCallback.stateChangeComplete()
    }

    // share activity through context
    override fun getSystemService(name: String): Any? = when {
        name == TAG -> this
        else -> super.getSystemService(name)
    }

    companion object {
        private val TAG = "MainActivity"

        @SuppressLint("WrongConstant")
        operator fun get(context: Context): MainActivity {
            return context.getSystemService(TAG) as MainActivity
        }
    }
}
