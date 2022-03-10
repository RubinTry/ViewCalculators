package cn.rubintry.viewcalculators

import android.widget.TextView


interface IModule<T : Number> {

    var textView : TextView?

    fun add(value: IModule<T>) : String

    fun subtract(value: IModule<T>) : String

    fun multiply(value: IModule<T> , scale: Int = 0) : String

    fun divide(value: IModule<T> , scale: Int = 0): String

    fun appendUnit(unit: String)

    fun getNumberFromView() : String

    override fun toString() : String
}
