package elton.com.simplestacktest.feature.dashboardblock

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import elton.com.simplestacktest.BaseFragment
import org.jetbrains.anko.AnkoContext
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by elton on 16/04/2018.
 */

class DashboardBlockFragment: BaseFragment() {

    @Inject lateinit var retrofit: Retrofit

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DashboardBlockUI().createView(AnkoContext.Companion.create(mainActivity, this))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i(retrofit.toString())
    }
}