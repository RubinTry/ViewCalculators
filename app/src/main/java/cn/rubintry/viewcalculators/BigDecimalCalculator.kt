package cn.rubintry.viewcalculators

import android.widget.TextView
import java.math.BigDecimal


/**
 * 高精度浮点计算器
 */
class BigDecimalCalculator : BaseCalculator<BigDecimal>() , ICalculator<BigDecimal>  {

    override fun forcePositive(): BigDecimalCalculator {
        forcePositive = true
        return this
    }

    override fun add(value: Any?): BigDecimalCalculator {
        checkResultNotNull()
        when(value){
            is BigDecimalModule -> {
                resultModule?.add(value)
            }

            is TextView -> {
                resultModule?.add(BigDecimalModule(value))
            }

            is String? -> {
                resultModule?.add(BigDecimalModule(value ?: "0"))
            }

            is Int -> {
                resultModule?.add(BigDecimalModule(value.toString()))
            }

            is Double -> {
                resultModule?.add(BigDecimalModule(value.toString()))
            }
        }

        return this
    }

    override fun subtract(value: Any?): BigDecimalCalculator {
        checkResultNotNull()
        when(value){
            is BigDecimalModule -> {
                resultModule?.subtract(value)
            }

            is TextView -> {
                resultModule?.subtract(BigDecimalModule(value))
            }

            is String? -> {
                resultModule?.subtract(BigDecimalModule(value ?: "0"))
            }

            is Int -> {
                resultModule?.subtract(BigDecimalModule(value.toString()))
            }

            is Double -> {
                resultModule?.add(BigDecimalModule(value.toString()))
            }
        }
        return this
    }


    override fun multiply(value: Any?, scale: Int): ICalculator<BigDecimal> {
        checkResultNotNull()
        when(value){
            is BigDecimalModule -> {
                resultModule?.multiply(value , scale)
            }

            is TextView -> {
                resultModule?.multiply(BigDecimalModule(value))
            }

            is String? -> {
                resultModule?.multiply(BigDecimalModule(value ?: "0") , scale)
            }

            is Int -> {
                resultModule?.multiply(BigDecimalModule(value.toString()) , scale)
            }

            is Double -> {
                resultModule?.add(BigDecimalModule(value.toString()))
            }
        }
        return this
    }


    override fun divide(value: Any?, scale: Int): ICalculator<BigDecimal> {
        checkResultNotNull()
        when(value){
            is BigDecimalModule -> {
                resultModule?.divide(value , scale)
            }

            is TextView -> {
                resultModule?.divide(BigDecimalModule(value) , scale)
            }

            is String? -> {
                resultModule?.divide(BigDecimalModule(value ?: "0") , scale)
            }

            is Int -> {
                resultModule?.divide(BigDecimalModule(value.toString()) , scale)
            }

            is Double -> {
                resultModule?.add(BigDecimalModule(value.toString()))
            }
        }
        return this
    }

    override fun appendUnit(unit: String): BigDecimalCalculator {
        checkResultNotNull()
        resultModule?.appendUnit(unit)
        return this
    }

    override fun into(vararg target: TextView?) : BigDecimalCalculator{
        assert(resultModule != null){"请先调用加减乘除方法"}
        for (textView in target) {
            textView?.text = resultModule?.getNumberFromView()
        }
        return this
    }

    override fun toString(): String {
        return resultModule.toString()
    }


}