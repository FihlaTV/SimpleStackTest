package elton.com.simplestacktest.feature.titlebargridlist

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.ankolayout.titleBar
import elton.com.simplestacktest.utils.constraintMatchParentParams
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by elton on 3/5/2018.
 **/
class TitleBarGridListUI: AnkoComponent<TitleBarGridListFragment> {
    override fun createView(ui: AnkoContext<TitleBarGridListFragment>): View {
        return with(ui) {
            constraintLayout {
                layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

                titleBar("TitleBarGridList") {
                    id = R.id.titleBarGridListTitleBar
                }
                        .addBackButton()
                        .lparams(matchParent, wrapContent) {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                verticalLayout {
                    recyclerView {
                        id = R.id.titleBarGridListRecyclerView
                    }.lparams(matchParent, matchParent)
                }.lparams(constraintMatchParentParams) {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topToBottom = R.id.titleBarGridListTitleBar
                    bottomToBottom = PARENT_ID
                }
            }
        }
    }
}