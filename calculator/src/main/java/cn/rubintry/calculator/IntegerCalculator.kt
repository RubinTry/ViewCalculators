package cn.rubintry.calculator

import android.widget.TextView
import java.math.BigDecimal


class IntegerCalculator : BaseCalculator<Int>(), ICalculator<Int> {

    override fun forcePositive(): IntegerCalculator {
        forcePositive = true
        return this
    }

    override fun add(value: Any?): ICalculator<Int> {
        checkResultNotNull()
        when(value){
            is IntegerModule -> {
                resultModule?.add(value)
            }

            is TextView -> {
                resultModule?.add(IntegerModule(value))
            }

            is String? -> {
                resultModule?.add(IntegerModule(value ?: "0"))
            }

            is Int -> {
                resultModule?.add(IntegerModule(value.toString()))
            }

            is Double -> {
                resultModule?.add(IntegerModule(value.toInt().toString()))
            }

            is BigDecimal -> {
                resultModule?.add(IntegerModule(value.toInt().toString()))
            }
        }
        return this
    }

    override fun subtract(value: Any?): IntegerCalculator {
        checkResultNotNull()
        when(value){
            is IntegerModule -> {
                resultModule?.subtract(value)
            }

            is TextView -> {
                resultModule?.subtract(IntegerModule(value))
            }

            is String? -> {
                resultModule?.subtract(IntegerModule(value ?: "0"))
            }

            is Int -> {
                resultModule?.subtract(IntegerModule(value.toString()))
            }

            is Double -> {
                resultModule?.subtract(IntegerModule(value.toInt().toString()))
            }

            is BigDecimal -> {
                resultModule?.subtract(IntegerModule(value.toInt().toString()))
            }
        }
        return this
    }

    override fun multiply(value: Any?, scale: Int): ICalculator<Int> {
        checkResultNotNull()
        when(value){
            is IntegerModule -> {
                resultModule?.multiply(value , scale)
            }

            is TextView -> {
                resultModule?.multiply(IntegerModule(value) , scale)
            }

            is String? -> {
                resultModule?.multiply(IntegerModule(value ?: "0") , scale)
            }

            is Int -> {
                resultModule?.multiply(IntegerModule(value.toString()) , scale)
            }

            is Double -> {
                resultModule?.multiply(IntegerModule(value.toInt().toString()))
            }

            is BigDecimal -> {
                resultModule?.multiply(IntegerModule(value.toInt().toString()))
            }
        }
        return this
    }


    override fun divide(value: Any?, scale: Int): IntegerCalculator {
        checkResultNotNull()
        when(value){
            is IntegerModule -> {
                resultModule?.divide(value , scale)
            }

            is TextView -> {
                resultModule?.divide(IntegerModule(value) , scale)
            }

            is String? -> {
                resultModule?.divide(IntegerModule(value ?: "0") , scale)
            }

            is Int -> {
                resultModule?.divide(IntegerModule(value.toString()) , scale)
            }

            is Double -> {
                resultModule?.divide(IntegerModule(value.toInt().toString()))
            }

            is BigDecimal -> {
                resultModule?.divide(IntegerModule(value.toInt().toString()))
            }
        }
        return this
    }

    override fun appendUnit(unit: String): IntegerCalculator {
        checkResultNotNull()
        resultModule?.appendUnit(unit)
        return this
    }


    override fun into(vararg target: TextView?) : IntegerCalculator {
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