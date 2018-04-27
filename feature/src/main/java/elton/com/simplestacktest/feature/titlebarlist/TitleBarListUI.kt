package elton.com.simplestacktest.feature.titlebarlist

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.View
import android.view.ViewGroup
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.ankolayout.titleBar
import elton.com.simplestacktest.utils.constraintMatchParentParams
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by elton on 23/4/2018.
 **/
class TitleBarListUI: AnkoComponent<TitleBarListFragment> {
    override fun createView(ui: AnkoContext<TitleBarListFragment>): View {

        return with(ui) {
            constraintLayout {
                layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

                titleBar("Test") {
                    id = R.id.title
                }
                        .addBackButton()
                        .addSubTitle(text = "Current Device: 0", doubleElevation = true)
                        .lparams(matchParent, wrapContent) {
                            startToStart = PARENT_ID
                            endToEnd = PARENT_ID
                        }

                verticalLayout {
                    recyclerView {
                        id = R.id.titleBarListRecyclerView
                    }.lparams(matchParent, matchParent)
                }.lparams(constraintMatchParentParams) {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topToBottom = R.id.title
                    bottomToBottom = PARENT_ID
                }
            }
        }
    }
}