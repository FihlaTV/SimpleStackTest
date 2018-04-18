package elton.com.simplestacktest.utils

import android.support.v4.app.Fragment

/**
 * Created by zhuinden on 2018. 03. 03..
 */
val Fragment.requireArguments
    get() = this.arguments ?: throw IllegalStateException("Arguments should exist!")

/**
 * Created by elton on 11/04/2018.
 */
inline fun keyName(clazz: Any): String {
    val lastIndex = clazz.toString().indexOf("$").takeIf { it != -1 } ?: clazz.toString().lastIndex + 1
    return clazz.toString().substring(
            clazz.toString().lastIndexOf(".") + 1,
            lastIndex
    )
}

