package elton.com.simplestacktest.feature.dashboardblock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.BaseFragment
import org.jetbrains.anko.AnkoContext

/**
 * Created by elton on 16/04/2018.
 */

class DashboardBlockFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DashboardBlockUI().createView(AnkoContext.Companion.create(mainActivity, this))
    }
}