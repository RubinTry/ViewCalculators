package cn.rubintry.viewcalculators

import java.math.BigDecimal

final class CalculatorFactory {

    companion object{
        @JvmStatic
        fun create(clazz: Class<out Number>) : ICalculator{
            return when{
                clazz.isAssignableFrom(BigDecimal::class.java) -> {
                    BigDecimalCalculator()
                }

                else -> {
                    IntegerCalculator()
                }
            }
        }
    }
}