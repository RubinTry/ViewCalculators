package cn.rubintry.viewcalculators

import android.widget.TextView

interface ICalculator<T : Number> {
    /**
     * 强制获取正数
     */
    fun forcePositive(): ICalculator<T>

    /**
     * 加法运算
     * @param value  参与运算的值
     */
    fun add(value: Any?) : ICalculator<T>


    /**
     * 减法运算
     * @param value  参与运算的值
     */
    fun subtract(value: Any?) : ICalculator<T>

    /**
     * 乘法运算
     *
     * @param value 参与运算的值
     * @param scale 运算结果保留几位小数
     * @return
     */
    fun multiply(value: Any? , scale: Int = 0): ICalculator<T>


    /**
     * 除法运算
     *
     * @param value 参与运算的值
     * @param scale 运算结果保留几位小数
     * @return
     */
    fun divide(value: Any? , scale: Int = 0): ICalculator<T>

    /**
     * 将运算结果装进目标节点
     * @param target 目标节点（要展示的地方）
     */
    fun into(vararg target : TextView?) : ICalculator<T>

    /**
     * 添加单位
     * @param unit 单位：例如，元
     */
    fun appendUnit(unit: String) : ICalculator<T>


    /**
     * 返回结果
     */
    override fun toString(): String
}