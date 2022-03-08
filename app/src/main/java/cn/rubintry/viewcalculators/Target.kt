package cn.rubintry.viewcalculators

import android.widget.TextView
import java.math.BigDecimal

interface Target {
    var textView : TextView
}

inline fun <reified T : Number> Target.getNumber(): T {
    return when{
        T::class.java.isAssignableFrom(BigDecimal::class.java) -> {
            this.textView.text.toString().toBigDecimal() as T
        }

        else -> {
            this.textView.text.toString().toInt() as T
        }
    }
}