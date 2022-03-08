package cn.rubintry.test

import java.util.regex.Pattern


/**
 * 从字符串中提取数字，包括正数负数浮点数
 *
 * @return
 */
fun String.getNumber(): List<CharSequence> {
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