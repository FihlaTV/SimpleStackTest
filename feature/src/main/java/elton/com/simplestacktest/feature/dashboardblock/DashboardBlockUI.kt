package elton.com.simplestacktest.feature.dashboardblock

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.blockLayout
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
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        return with(ui) {
            constraintLayout {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

                verticalLayout {
                    linearLayout {
                        // Null BlockLayout as the first one cannot have ripple effect.
                        blockLayout("NULL").lparams(width = 0, weight = 0f)
                        blockLayout("Block 1", R.drawable.ic_blur_circular_black_24dp)
                                .lparams(matchParentParams) {
                                    weight = 1f
                                }
                    }.lparams(matchParentParams) {
                        weight = 0.3f
                    }

                    linearLayout {
                        blockLayout("Block 2", R.drawable.ic_blur_circular_black_24dp)
                                .lparams(matchParentParams) {
                                    weight = 0.5f
                                }
                        blockLayout("Block 3", R.drawable.ic_blur_circular_black_24dp)
                                .lparams(matchParentParams) {
                                    weight = 0.5f
                                }
                    }.lparams(matchParentParams) {
                        weight = 0.3f
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
                        weight = 0.3f
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