package elton.com.simplestacktest.utils.ankolayout

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.constraint.ConstraintLayout.LayoutParams.UNSET
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import elton.com.simplestacktest.feature.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout._ConstraintLayout
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.guideline
import org.jetbrains.anko.custom.ankoView
import timber.log.Timber

/**
 * Created by elton on 18/4/2018.
 **/
class BlockLayout: LinearLayout {

    lateinit var mView: AnkoContext<BlockLayout>
    lateinit var mBaseLayout: ConstraintLayout
    lateinit var mTextView: TextView
    lateinit var mImageView: ImageView

    private fun init(words: String, drawable: Int, onClickBehaviour: OnClickListener? = null): AnkoContext<BlockLayout> {
        mView = AnkoContext.createDelegate(this).apply {
            mBaseLayout = constraintLayout {
                id = R.id.blockLayout
                backgroundResource = R.drawable.block_layout_background
                layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )

                guideline {
                    id = R.id.guideline_40
                }.lparams {
                    orientation = ConstraintLayout.LayoutParams.HORIZONTAL
                    guidePercent = 0.4f
                }

                guideline {
                    id = R.id.guideline_60
                }.lparams {
                    orientation = ConstraintLayout.LayoutParams.HORIZONTAL
                    guidePercent = 0.6f
                }

                setOnClickListener {
                    Timber.i("$words")
                }

                if (onClickBehaviour != null) {
                    setOnClickListener(onClickBehaviour)
                }

                mTextView = textView(words) {
                    id = R.id.blockTextView

                    textSize = 17f

                }.lparams(wrapContent, wrapContent) {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topToTop = PARENT_ID
                    bottomToBottom = PARENT_ID
                }

                mImageView = imageView(drawable) {

                }.lparams {
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topToTop = PARENT_ID
                    bottomToBottom = PARENT_ID
                }
            }
        }

        return mView
    }

    fun addSubTitle(words: String): BlockLayout {
        val titleLayoutParams = (mTextView.layoutParams as ConstraintLayout.LayoutParams)
        titleLayoutParams.topToTop = R.id.guideline_40
        titleLayoutParams.bottomToBottom = R.id.guideline_40

        (mBaseLayout as _ConstraintLayout).apply {
            textView(words)
                    .lparams(wrapContent, wrapContent) {
                        startToStart = PARENT_ID
                        endToEnd = PARENT_ID
                        topToTop = R.id.guideline_60
                        bottomToBottom = R.id.guideline_60
                    }
        }

        return mView.owner
    }

    fun alignToEnd(): BlockLayout {
        mTextView.apply {
            padding = dip(8)
            val lparams = (this.layoutParams as ConstraintLayout.LayoutParams)
            lparams.startToStart = UNSET
        }

        mImageView.apply {
            val lparams = (this.layoutParams as ConstraintLayout.LayoutParams)
            lparams.startToStart = UNSET
            lparams.endToEnd = UNSET
            lparams.endToStart = R.id.blockTextView
        }

        return mView.owner
    }

    constructor(context: Context?) : super(context) {
        init("", 0)
    }

    constructor(context: Context?, words: String, drawable: Int, onClickBehaviour: OnClickListener? = null) : super(context) {
        init(words, drawable, onClickBehaviour)
    }

    constructor(context: Context?, attrs: AttributeSet?, words: String, drawable: Int) : super(context, attrs) {
        init(words, drawable)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, words: String, drawable: Int) : super(context, attrs, defStyleAttr) {
        init(words, drawable)
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.blockLayout(words: String, drawable: Int = 0, onClickBehaviour: View.OnClickListener? = null, init: BlockLayout.() -> Unit = {}) =
        ankoView({ctx -> BlockLayout(ctx, words, drawable, onClickBehaviour) }, 0, init)