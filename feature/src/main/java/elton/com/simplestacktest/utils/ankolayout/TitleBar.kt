package elton.com.simplestacktest.utils.ankolayout

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.LinearLayout
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7._Toolbar
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.custom.ankoView
import timber.log.Timber

/**
 * Created by elton on 19/4/2018.
 **/
class TitleBar: LinearLayout {

    lateinit var mView: AnkoContext<TitleBar>
    lateinit var layout: LinearLayout
    lateinit var toolbar: Toolbar

    private fun init(): AnkoContext<TitleBar> {

        mView = AnkoContext.createDelegate(this).apply {
            layout = linearLayout {
                toolbar = toolbar {
                    id = R.id.titlebar
                    layoutParams = Toolbar.LayoutParams(matchParent, wrapContent)

                    backgroundColor = Color.WHITE
                    elevation = 8f

                    textView("Title") {
                        textSize = 16f
                        textColor = Color.BLACK
                    }.lparams(
                            wrapContent,
                            wrapContent
                    ) {
                        gravity = Gravity.CENTER
                    }

                }.lparams(
                        matchParent,
                        wrapContent
                )

                bottomPadding = 5
                clipToPadding = false
                layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
            }
        }

        return mView
    }

    fun addButton(imgRes: Int = R.drawable.ic_add_black_24dp, gravity: Int = Gravity.START, id: Int = 0, onClickListener: OnClickListener? = null): TitleBar {
        val attrs = intArrayOf(android.R.attr.selectableItemBackground)
        (toolbar as _Toolbar).apply {
            imageView(imgRes) {
                background = mView.ctx.obtainStyledAttributes(attrs).getDrawable(0)
                isClickable = true
                verticalPadding = dip(16)
                horizontalPadding = dip(16)
//                clipToPadding = false
                setOnClickListener {
                    Timber.i("TEST")
                }
                if (onClickListener != null) {
                    setOnClickListener(onClickListener)
                }
            }.lparams(Toolbar.LayoutParams(wrapContent, wrapContent)) {
                this.gravity = gravity
                if (gravity == Gravity.END) {
                    marginEnd = dip(16)
                }
            }
        }
        return mView.owner
    }

    fun addBackButton(onClickListener: OnClickListener? = null): TitleBar {
        // Default behaviour as clicking the back button on Navigation bar
        return addButton(R.drawable.ic_navigate_before_black_24dp, onClickListener = OnClickListener { (context as MainActivity).onBackPressed() })
    }

    fun addClickableText(text: String, gravity: Int = Gravity.START, id: Int = 0, onClickListener: OnClickListener? = null): TitleBar {
        val attrs = intArrayOf(android.R.attr.selectableItemBackground)
        (toolbar as _Toolbar).apply {
            textView(text) {
                this.id = id
                background = mView.ctx.obtainStyledAttributes(attrs).getDrawable(0)
                isClickable = true
                textSize = 16f
                verticalPadding = dip(16)
                horizontalPadding = dip(16)

                if (onClickListener != null) {
                    setOnClickListener(onClickListener)
                }
            }.lparams(Toolbar.LayoutParams(wrapContent, wrapContent)) {
                this.gravity = gravity
                if (gravity == Gravity.END) {
                    marginEnd = dip(16)
                }
            }
        }
        return mView.owner
    }

    constructor(context: Context?): super(context) {
        init()
    }

}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.titleBar(init: TitleBar.() -> Unit) =
        ankoView(::TitleBar, 0, init)