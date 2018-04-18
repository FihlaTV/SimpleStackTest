package elton.com.simplestacktest.utils

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import elton.com.simplestacktest.feature.R
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.imageView
import org.jetbrains.anko.textView
import timber.log.Timber

/**
 * Created by elton on 16/04/2018.
 */

inline fun ViewManager.blockLayout(words: String, drawable: Int = 0): View {
    val view = constraintLayout {
        backgroundResource = R.drawable.block_layout_background
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        )

        setOnClickListener {
            Timber.i("$words")
        }

        textView(words) {

        }.lparams {
            startToStart = PARENT_ID
            endToEnd = PARENT_ID
            topToTop = PARENT_ID
            bottomToBottom = PARENT_ID
        }

        imageView(drawable) {

        }.lparams {
            startToStart = PARENT_ID
            endToEnd = PARENT_ID
            topToTop = PARENT_ID
            bottomToBottom = PARENT_ID
        }

    }

    return view
}