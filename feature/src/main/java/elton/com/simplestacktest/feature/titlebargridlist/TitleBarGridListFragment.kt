package elton.com.simplestacktest.feature.titlebargridlist

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter.items
import elton.com.simplestacktest.BaseFragment
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.SpanningGridLayoutManager
import org.jetbrains.anko.AnkoContext

/**
 * Created by elton on 3/5/2018.
 **/
class TitleBarGridListFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TitleBarGridListUI().createView(AnkoContext.create(mainActivity, this))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.titleBarGridListRecyclerView)
        val itemAdapter = items<GridItem>()
        val fastAdapter = FastAdapter.with<GridItem, ItemAdapter<GridItem>>(itemAdapter)

        val list = listOf(
                GridItem("Test"),
                GridItem("Two", "Subtitle"),
                GridItem("FFF"),
                GridItem("RER"),
                GridItem("Fifth")
//                GridItem("Sixth")
        )

        recyclerView.layoutManager = SpanningGridLayoutManager(mainActivity, 2).apply {
            spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
//                    if (position == 0) return 2
                    return 1
                }
            }
        }
        recyclerView.adapter = fastAdapter
        itemAdapter.add(list)
        fastAdapter.notifyAdapterDataSetChanged()
    }
}