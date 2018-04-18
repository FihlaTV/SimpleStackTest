package elton.com.simplestacktest.feature.baseone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.feature.home.HomeKey
import kotlinx.android.synthetic.main.base_one_view.*

/**
 * Created by elton on 16/04/2018.
 */

class BaseOneFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.base_one_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nextButton.setOnClickListener {
            MainActivity.get(view.context).navigateTo(HomeKey())
        }
    }
}