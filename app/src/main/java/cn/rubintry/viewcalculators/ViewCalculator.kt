package cn.rubintry.viewcalculators

final class ViewCalculator {

    companion object{
        @JvmStatic
        fun with(clazz: Class<out Number>): ICalculator {
            return CalculatorFactory.create(clazz)
        }

        @JvmStatic
        fun <T : ICalculator> asCustom(clazz: Class<T>): T {
            return clazz.newInstance()
        }


    }


}