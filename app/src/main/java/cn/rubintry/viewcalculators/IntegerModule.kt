package cn.rubintry.viewcalculators

import android.widget.TextView

class IntegerModule(override var textView: TextView?) : IModule<Int> {

    private var resultValue : String ?= null

    constructor(value : String) : this(null){
        resultValue = value
    }

    override fun getNumberFromView(): String {
        return resultValue?.getNumber()?.get(0)?.toString() ?: textView?.getNumberString() ?: "0"
    }

    override fun add(value: IModule<Int>): String {
        val param1 = getNumberFromView().toInt() ?: 0
        val param2 = value.getNumberFromView().toInt() ?: 0
        return (param1 + param2).toString()
    }

    override fun subtract(value: IModule<Int>): String {
        val param1 = getNumberFromView().toInt() ?: 0
        val param2 = value.getNumberFromView().toInt() ?: 0
        return (param2 - param1).toString()
    }

    override fun multiply(value: IModule<Int>, scale: Int): String {
        val param1 = getNumberFromView().toInt() ?: 0
        val param2 = value.getNumberFromView().toInt() ?: 0
        return (param2 * param1).toString()
    }

    override fun divide(value: IModule<Int>, scale: Int): String {
        val param1 = getNumberFromView().toInt() ?: 0
        val param2 = value.getNumberFromView().toInt() ?: 0
        assert(param1 != 0){"除数不可为0"}
        return (param2 / param1).toString()
    }

    override fun toString(): String {
        return getNumberFromView()
    }

    override fun appendUnit(unit: String) {

    }


}