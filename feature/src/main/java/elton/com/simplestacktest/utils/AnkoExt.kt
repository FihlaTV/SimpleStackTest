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
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

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

class ReferenceViewProperty<T>(var property: () -> T) : ReadWriteProperty<Any, T> {

    private var value: Any? = null

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        value = this.property.invoke()
        return value as T
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        this.value = value
    }
}

inline fun <reified T> testProp(noinline init: () -> T): ReadWriteProperty<Any, T> = ReferenceViewProperty(init)