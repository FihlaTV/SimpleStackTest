package elton.com.simplestacktest.feature.dashboardblock

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.feature.baseone.BaseOneKey
import elton.com.simplestacktest.feature.titlebarbasic.TitleBarBasicKey
import elton.com.simplestacktest.utils.ankolayout.blockLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import timber.log.Timber

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
            coordinatorLayout {
//                fitsSystemWindows = true
                layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

                appBarLayout {
                    addOnOffsetChangedListener({ appBarLayout, verticalOffset ->
                        Timber.i(verticalOffset.toString())
                    })
                    collapsingToolbarLayout {
                        imageView() {}.lparams(matchParent, matchParent) {
                            collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
                        }
                    }.lparams(matchParent, 300) {
                        scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL + AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
                    }
                }.lparams(matchParent, wrapContent)

                verticalLayout {
                    id = R.id.scrollLinearLayout
                    constraintLayout {
                        //                    layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

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
                                blockLayout("Block 3", R.drawable.ic_blur_circular_black_24dp) {
                                    visibility = View.INVISIBLE
                                }
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
                    }.lparams(matchParentParams) {

                    }
                }.lparams {
                    width = matchParent
                    height = matchParent
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }

            }
        }
    }
}