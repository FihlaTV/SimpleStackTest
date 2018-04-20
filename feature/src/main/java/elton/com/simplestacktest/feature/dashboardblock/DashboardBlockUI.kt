package elton.com.simplestacktest.feature.dashboardblock

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.feature.baseone.BaseOneKey
import elton.com.simplestacktest.feature.titlebarbasic.TitleBarBasicKey
import elton.com.simplestacktest.utils.ankolayout.blockLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * Created by elton on 16/04/2018.
 */

class DashboardBlockUI: AnkoComponent<DashboardBlockFragment> {
    override fun createView(ui: AnkoContext<DashboardBlockFragment>): View {
        val constraintMatchParentParams =
                ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD,
                        ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                )
        val matchParentParams =
                ViewGroup.LayoutParams(
                        matchParent,
                        matchParent
                )
        return with(ui) {
            constraintLayout {
                layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

                verticalLayout {
                    blockLayout("Add Device", R.drawable.ic_add_black_24dp).alignToEnd()
                            .lparams(matchParentParams) {
                                weight = 1.3f
                            }
                    linearLayout {
                        blockLayout("Test", R.drawable.ic_blur_circular_black_24dp,
                                View.OnClickListener {
                                    MainActivity[view.context].navigateTo(BaseOneKey())
                                }
                        )
                                .lparams(matchParentParams) {
                                    weight = 1f
                                }

                    }.lparams(matchParentParams) {
                        weight = 1f
                    }

                    linearLayout {
                        blockLayout("Block 2", R.drawable.ic_blur_circular_black_24dp,
                                View.OnClickListener {
                                    MainActivity[view.context].homeFragment?.navigateTo(TitleBarBasicKey())
                                })
                                .lparams(matchParentParams) {
                                    weight = 0.5f
                                }
                        blockLayout("Block 3", R.drawable.ic_blur_circular_black_24dp)
                                .lparams(matchParentParams) {
                                    weight = 0.5f
                                }
                    }.lparams(matchParentParams) {
                        weight = 1f
                    }

                    linearLayout {
                        blockLayout("Block 4", R.drawable.ic_blur_circular_black_24dp)
                                .lparams(matchParentParams) {
                            weight = 0.5f
                        }
                        blockLayout("Block 5", R.drawable.ic_blur_circular_black_24dp)
                                .lparams(matchParentParams) {
                            weight = 0.5f
                        }
                    }.lparams(matchParentParams) {
                        weight = 1f
                    }

                }.lparams(constraintMatchParentParams) {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topToTop = PARENT_ID
                    bottomToBottom = PARENT_ID
                }
            }
        }
    }
}