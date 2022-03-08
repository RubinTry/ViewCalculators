package cn.rubintry.viewcalculators

import java.math.BigDecimal

class ValueCaster {
    companion object{
        @JvmStatic
        inline fun <reified T : Number> cast(str : CharSequence) : T{
            return when{
                T::class.java.isAssignableFrom(BigDecimal::class.java) -> {
                    str.toString().toBigDecimal() as T
                }

                else -> {
                    str.toString().toInt() as T
                }
            }
        }
    }
}