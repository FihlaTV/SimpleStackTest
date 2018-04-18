package elton.com.simplestacktest.feature.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.R

/**
 * Created by elton on 16/04/2018.
 */

class DashboardFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dashboard_view, container, false)
        return view
    }
}