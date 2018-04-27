package elton.com.simplestacktest.feature.titlebarbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.R
import org.jetbrains.anko.AnkoContext

/**
 * Created by elton on 19/4/2018.
 **/
class TitleBarBasicFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TitleBarBasicUI().createView(AnkoContext.create(mainActivity, this, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}