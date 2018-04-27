package elton.com.simplestacktest.utils.ankolayout

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.TextView
import elton.com.simplestacktest.feature.MainActivity
import elton.com.simplestacktest.feature.R
import elton.com.simplestacktest.utils.testProp
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
    lateinit var mTitleTextView: TextView
    lateinit var layout: LinearLayout
    lateinit var toolbar: Toolbar

    private fun init(titleString: CharSequence? = null): AnkoContext<TitleBar> {

        mView = AnkoContext.createDelegate(this).apply {
            layout = verticalLayout {
                toolbar = toolbar {
                    id = R.id.titlebar
                    layoutParams = Toolbar.LayoutParams(matchParent, wrapContent)

                    backgroundColor = Color.WHITE
                    elevation = 8f

                    mTitleTextView = textView {
                        text = titleString ?: "Title"
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

                bottomPadding = 8
                clipToPadding = false
                layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)

            }
        }

        return mView
    }

    fun addSubTitle(imgRes: Int = R.drawable.ic_add_black_24dp, text: String = "", doubleElevation: Boolean = false): TitleBar {
//        toolbar.bottomPadding = 0
        if (doubleElevation) {
            toolbar.elevation = 16f
        }
        (layout as _LinearLayout).apply {
            linearLayout {
                backgroundColor = Color.WHITE
                elevation = 8f
                bottomPadding = 8
                verticalPadding = dip(8)

                imageView(imgRes) {
                    leftPadding = dip(16)
                    rightPadding = dip(8)
                }.lparams(wrapContent, wrapContent) {
                    gravity = Gravity.CENTER_VERTICAL
                }
                textView(text) {
                    textSize = 20f
                }.lparams(matchParent, wrapContent) {
                    gravity = Gravity.CENTER_VERTICAL
                }
            }.lparams(matchParent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
            }

        }
        return mView.owner
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

    constructor(context: Context?, titleString: CharSequence): super(context) {
        init(titleString)
    }

}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.titleBar(init: TitleBar.() -> Unit = {}) =
        ankoView(::TitleBar, 0, { init () })

inline fun ViewManager.titleBar(titleString: CharSequence, init: TitleBar.() -> Unit = {}) =
        ankoView({ ctx -> TitleBar(ctx, titleString) }, 0, { init () })