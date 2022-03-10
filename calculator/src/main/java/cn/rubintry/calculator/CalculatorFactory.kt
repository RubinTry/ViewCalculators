package cn.rubintry.calculator

import java.math.BigDecimal

final class CalculatorFactory {

    companion object{
        @JvmStatic
        fun create(clazz: Class<out Number>) : ICalculator<*> {
            if(clazz.isInterface){
                throw IllegalArgumentException("请传入具体的数值实现类，以便进行运算。如：Integer(java里的) , BigDecimal")
            }
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