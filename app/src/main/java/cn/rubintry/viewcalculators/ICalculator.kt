package cn.rubintry.viewcalculators

import android.widget.TextView

interface ICalculator {
    fun add(value: IModule) : ICalculator

    fun add(value: TextView) : ICalculator

    fun into(vararg target : TextView)

    fun into(vararg target: Target)
}