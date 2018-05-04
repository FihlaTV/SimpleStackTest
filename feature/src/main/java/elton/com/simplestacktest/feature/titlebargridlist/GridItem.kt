package elton.com.simplestacktest.feature.titlebargridlist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.ankolayout.BlockLayout
import elton.com.simplestacktest.utils.ankolayout.blockLayout
import org.jetbrains.anko.*
import timber.log.Timber

/**
 * Created by elton on 3/5/2018.
 **/
class GridItem(val name: String, val subTitle: String = ""): AbstractItem<GridItem, GridItem.ViewHolder>() {

    override fun getType(): Int {
        return R.id.fastadapter_griditem_id
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun getLayoutRes(): Int = R.layout.griditem_view

    override fun createView(ctx: Context, parent: ViewGroup?): View {
        val viewContainer = ctx.UI {
            verticalLayout {
                blockLayout()
                        .addSubTitle()
                        .lparams(matchParent, matchParent)
            }
        }
        return viewContainer.view
//        return super.createView(ctx, parent)
    }

    class ViewHolder(val view: View): FastAdapter.ViewHolder<GridItem>(view) {
        lateinit var textView: TextView
        lateinit var blockLayout: BlockLayout

        override fun bindView(item: GridItem, payloads: MutableList<Any>?) {
            blockLayout = view.findViewById(R.id.blockLayoutBase)
            blockLayout.mBaseLayout.setOnClickListener { Timber.i(item.name) }
            blockLayout.mTextView.text = item.name
            blockLayout.mSubTitle.text = item.subTitle
/*
            textView = view.findViewById(R.id.gridItemTextView)
            textView.text = item.name
*/
        }

        override fun unbindView(item: GridItem?) {
//            textView.text = ""
        }
    }
}