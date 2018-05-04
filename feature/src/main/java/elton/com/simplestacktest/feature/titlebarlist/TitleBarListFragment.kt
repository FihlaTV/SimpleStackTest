package elton.com.simplestacktest.feature.titlebarlist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter.items
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.R
import org.jetbrains.anko.AnkoContext

/**
 * Created by elton on 23/4/2018.
 **/
class TitleBarListFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TitleBarListUI().createView(AnkoContext.create(mainActivity, this, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.titleBarListRecyclerView)
        val itemAdapter = items<ListItem>()
        val fastAdapter = FastAdapter.with<ListItem, ItemAdapter<ListItem>>(itemAdapter)

        val list = listOf(ListItem("12321"), ListItem("24112"))


        recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        recyclerView.adapter = fastAdapter
        itemAdapter.add(list)
        fastAdapter.notifyAdapterDataSetChanged()

    }
}