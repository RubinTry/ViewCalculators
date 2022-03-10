package cn.rubintry.viewcalculators

import android.widget.TextView
import java.math.BigDecimal
import java.util.regex.Pattern

open class BaseCalculator<T: Number> {

    protected var resultModule : DefaultModule<T>? = null

    protected var forcePositive = false

    fun checkResultNotNull(){
        if(null == resultModule){
            resultModule = DefaultModule(null)
        }
    }


    /**
     * 基础数据模型
     *
     * @param N
     * @property textView
     */
    inner class DefaultModule<N : Number>(override var textView: TextView?) : IModule<N>{
        private var result = "0"
        private var unit: String = ""

        override fun getNumberFromView(): String {
            if(forcePositive && result.startsWith("-")){
                result = result.substring(1 , result.length)
            }
            if(unit.isNotEmpty() && !result.endsWith(unit)){
                result = result.plus(unit)
            }
            return result
        }

        override fun add(value: IModule<N>): String {
            result = value.add(this)
            return result
        }

        override fun subtract(value: IModule<N>): String {
            result = value.subtract(this)
            return result
        }

        override fun multiply(value: IModule<N>, scale: Int): String {
            result = value.multiply(this , scale)
            return result
        }

        override fun divide(value: IModule<N>, scale: Int): String {
            result = value.divide(this , scale)
            return result
        }

        override fun toString(): String {
            if(forcePositive && result.startsWith("-")){
                result = result.substring(1 , result.length)
            }
            if(unit.isNotEmpty()){
                result = result.plus(unit)
            }
            return result
        }

        override fun appendUnit(unit: String) {
            this.unit = unit
        }

    }

}

/**
 * 从字符串中提取数字，包括正数负数浮点数
 *
 * @return
 */
internal fun CharSequence.getNumber(): List<CharSequence> {
    val numberList = mutableListOf<CharSequence>()
    val p = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+")
    val m = p.matcher(this)

    while(m.find()){
        val result = this.subSequence(m.start() , m.end())
        numberList.add(result)
    }
    return numberList
}

internal fun List<CharSequence>.firstOrEmpty(): CharSequence {
    if(this.isNotEmpty()){
        return this.first()
    }
    return ""
}

internal fun TextView.getNumberString() : String{
    return this.text.getNumber().firstOrEmpty().toString()
}