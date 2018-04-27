package elton.com.simplestacktest.feature.titlebarbasic

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.ankolayout.blockLayout
import elton.com.simplestacktest.utils.ankolayout.titleBar
import elton.com.simplestacktest.utils.constraintMatchParentParams
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * Created by elton on 19/4/2018.
 **/
class TitleBarBasicUI: AnkoComponent<TitleBarBasicFragment> {
    override fun createView(ui: AnkoContext<TitleBarBasicFragment>): View {
        return with(ui) {
            constraintLayout {
                layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)

                titleBar {
                    id = R.id.title
                }
                        .addSubTitle(text = "Device(s)")
                        .addBackButton()
                        .addButton(R.drawable.ic_add_black_24dp, Gravity.END)
//                        .addClickableText("TEST", Gravity.END)
                        .lparams(matchParent, wrapContent) {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                verticalLayout {
                    linearLayout {
                        blockLayout("TEST", R.drawable.ic_blur_circular_black_24dp)
                                .addSubTitle("Sub")
                                .lparams(matchParent, matchParent, weight = 1f)

                        blockLayout("TEST")
//                                .addSubTitle("Sub2")
                                .lparams(matchParent, matchParent, weight = 1f)

                    }.lparams(matchParent, wrapContent, weight = 1f)

                    linearLayout {
                        blockLayout("TEST", R.drawable.ic_blur_circular_black_24dp)
                                .addSubTitle("Sub")
                                .lparams(matchParent, matchParent, weight = 1f)

                        blockLayout("TEST")
                                .addSubTitle("Sub2")
                                .lparams(matchParent, matchParent, weight = 1f)

                    }.lparams(matchParent, wrapContent, weight = 1f)

                    linearLayout {
                        blockLayout("TEST", R.drawable.ic_blur_circular_black_24dp)
                                .addSubTitle("Sub")
                                .lparams(matchParent, matchParent, weight = 1f)

                        blockLayout("TEST") {
                            visibility = View.INVISIBLE
                        }
                                .addSubTitle("Sub2")
                                .lparams(matchParent, matchParent, weight = 1f)

                    }.lparams(matchParent, wrapContent, weight = 1f)
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