package elton.com.simplestacktest.feature.titlebarbasic

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.feature.dashboardblock.DashboardBlockUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.find

/**
 * Created by elton on 19/4/2018.
 **/
class TitleBarBasicFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TitleBarBasicUI().createView(AnkoContext.Companion.create(mainActivity, this, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val toolbar = find<Toolbar>(R.id.titlebar)
//        ViewCompat.setElevation(toolbar, 8f)
//        mainActivity.setSupportActionBar(toolbar)
    }
}