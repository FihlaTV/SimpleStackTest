package elton.com.simplestacktest.feature.dashboardblock

import android.graphics.Color
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
import elton.com.simplestacktest.feature.titlebarlist.TitleBarListKey
import elton.com.simplestacktest.utils.ankolayout.blockLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.guideline
import org.jetbrains.anko.constraint.layout.matchConstraint
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.support.v4.nestedScrollView
import timber.log.Timber

/**
 * Created by elton on 16/04/2018.
 */

class DashboardBlockUI: AnkoComponent<DashboardBlockFragment> {
    override fun createView(ui: AnkoContext<DashboardBlockFragment>): View {
        return with(ui) {
            coordinatorLayout {
                layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

                appBarLayout {
                    id = R.id.homePageImage
                    addOnOffsetChangedListener({ appBarLayout, verticalOffset ->
                        Timber.i(verticalOffset.toString())
                    })
                    collapsingToolbarLayout {

                        imageView {

                        }.lparams(matchParent, matchParent) {
                            collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
                        }
                    }.lparams(matchParent, dip(128)) {
                        scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
                    }
                }.lparams(matchParent, wrapContent)

                nestedScrollView {
                    isFillViewport = true
                    id = R.id.scrollLinearLayout
                    constraintLayout {
                        guideline {
                            id = R.id.appBarGuideline
                        }.lparams {
                            orientation = ConstraintLayout.LayoutParams.HORIZONTAL
                            guideEnd = dip(128)
                        }
                        verticalLayout {
                            blockLayout("Add Device", R.drawable.ic_add_black_24dp).alignToEnd()
                                    .lparams(matchParent, matchParent) {
                                        weight = 1.3f
                                    }
                            linearLayout {
                                blockLayout("Test", R.drawable.ic_blur_circular_black_24dp,
                                        View.OnClickListener {
                                            MainActivity[view.context].replaceHistory(BaseOneKey())
                                        }
                                )
                                        .lparams(matchParent, matchParent) {
                                            weight = 1f
                                        }

                            }.lparams(matchParent, matchParent) {
                                weight = 1f
                            }

                            linearLayout {
                                blockLayout("Block 2", R.drawable.ic_blur_circular_black_24dp,
                                        View.OnClickListener {
                                            MainActivity[view.context].homeFragment?.navigateTo(TitleBarBasicKey())
                                        })
                                        .lparams(matchParent, matchParent) {
                                            weight = 0.5f
                                        }
                                blockLayout("Block 3", R.drawable.ic_blur_circular_black_24dp,
                                        View.OnClickListener {
                                            MainActivity[view.context].homeFragment?.navigateTo(TitleBarListKey())
                                        })
                                        .lparams(matchParent, matchParent) {
                                            weight = 0.5f
                                        }
                            }.lparams(matchParent, matchParent) {
                                weight = 1f
                            }

                            linearLayout {
                                blockLayout("Block 4", R.drawable.ic_blur_circular_black_24dp)
                                        .lparams(matchParent, matchParent) {
                                            weight = 0.5f
                                        }
                                blockLayout("Block 5", R.drawable.ic_blur_circular_black_24dp)
                                        .lparams(matchParent, matchParent) {
                                            weight = 0.5f
                                        }
                            }.lparams(matchParent, matchParent) {
                                weight = 1f
                            }

                        }.lparams(matchConstraint, matchConstraint) {
                            startToStart = PARENT_ID
                            endToEnd = PARENT_ID
                            topToTop = PARENT_ID
                            bottomToBottom = R.id.appBarGuideline
                        }
                    }.lparams(matchParent, matchParent) {

                    }
                }.lparams(matchParent, matchParent) {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        }
    }
}