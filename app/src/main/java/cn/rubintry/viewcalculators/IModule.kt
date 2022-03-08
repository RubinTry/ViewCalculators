package cn.rubintry.viewcalculators

import android.widget.TextView
import java.math.BigDecimal


interface IModule {
    var textView : TextView?

    fun add(value: IModule)

    fun getNumberFromView() : Any
}

inline fun <reified T : Number> IModule.getNumber(): T {
    return ValueCaster.cast(textView?.text ?: "0")
}