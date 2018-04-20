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
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.textView
import timber.log.Timber

/**
 * Created by elton on 16/04/2018.
 */

val matchParentParams =
        ViewGroup.LayoutParams(
                matchParent,
                matchParent
        )

val constraintMatchParentParams =
        ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
        )