package cn.rubintry.viewcalculators

import android.widget.TextView
import java.math.BigDecimal

class BigDecimalModule(override var textView: TextView?) : IModule<BigDecimal> {
    private var resultValue : String ?= null

    constructor(value: String): this(null){
        resultValue = value
    }

    override fun getNumberFromView(): String {
        return resultValue?.getNumber()?.get(0)?.toString() ?: textView?.getNumberString() ?: "0"
    }

    override fun add(value: IModule<BigDecimal>) : String{
        return getNumberFromView().toBigDecimal()
            .add(value.getNumberFromView().toBigDecimal())?.toPlainString() ?: "0"
    }

    override fun subtract(value: IModule<BigDecimal>): String {
        return value.getNumberFromView().toBigDecimal()
            .subtract(getNumberFromView().toBigDecimal())?.toPlainString() ?: "0"
    }

    override fun multiply(value: IModule<BigDecimal>, scale: Int): String {
        return value.getNumberFromView().toBigDecimal()
            .multiply(getNumberFromView().toBigDecimal())
            .setScale(scale)
            .toPlainString()
    }

    override fun divide(value: IModule<BigDecimal>, scale: Int): String {
        assert(getNumberFromView() != "0"){"除数不可为0"}
        return value.getNumberFromView().toBigDecimal()
            .divide(getNumberFromView().toBigDecimal() , scale , BigDecimal.ROUND_DOWN)
            .toPlainString()
    }

    override fun toString(): String {
        return getNumberFromView()
    }

    override fun appendUnit(unit: String) {

    }




}