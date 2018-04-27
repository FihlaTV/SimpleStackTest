package elton.com.simplestacktest.feature.titlebarlist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import elton.com.simplestacktest.feature.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by elton on 27/4/2018.
 **/
class ListItem(val name: String): AbstractItem<ListItem, ListItem.ViewHolder>() {

    override fun getType(): Int {
        return R.id.fastadapter_listitem_id
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun getLayoutRes(): Int = R.layout.listitem_view

    class ViewHolder(val view: View): FastAdapter.ViewHolder<ListItem>(view) {
        lateinit var listitemFirst: TextView

        override fun bindView(item: ListItem, payloads: MutableList<Any>?) {
            listitemFirst = view.findViewById(R.id.listitemFirst)

            listitemFirst.text = item.name
        }

        override fun unbindView(item: ListItem?) {
            listitemFirst.text = ""
        }
    }
}