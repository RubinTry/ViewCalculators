package cn.rubintry.viewcalculators

import android.widget.TextView
import java.util.regex.Pattern

open class BaseCalculator {

    protected var targetSets : MutableSet<Target> = mutableSetOf()

    protected var resultModule = DefaultModule(null)

    inner class DefaultModule(override var textView: TextView?) : IModule{
        override fun getNumberFromView(): Any {
            return 0
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
        println(result)
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