package cn.rubintry.viewcalculators

import android.widget.TextView

class BigDecimalCalculator : BaseCalculator() , ICalculator  {
    override fun add(value: IModule): ICalculator {
        TODO("Not yet implemented")
    }

    override fun add(value: TextView): ICalculator {
        TODO("Not yet implemented")
    }


    override fun into(vararg target: TextView) {
        for (textView in target) {
            targetSets.add(ViewTarget(textView))
        }
    }

    override fun into(vararg target: Target) {
        for (tar in target) {
            targetSets.add(tar)
        }
    }


}