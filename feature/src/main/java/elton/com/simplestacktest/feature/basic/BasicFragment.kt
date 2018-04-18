package elton.com.simplestacktest.feature.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.feature.other.OtherKey
import kotlinx.android.synthetic.main.first_view.*

/**
 * Created by elton on 16/04/2018.
 */

class BasicFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.first_view, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstButton.setOnClickListener {
            MainActivity.get(view.context).homeFragment?.navigateTo(OtherKey())
        }
    }
}