package cn.rubintry.viewcalculators

final class ViewCalculator {

    companion object{
        /**
         * 自动解析数据类型获得对应的计算器
         *
         * @param T
         * @param clazz
         * @return
         */
        @JvmStatic
        fun <T : Number> with(clazz: Class<T>): ICalculator<*> {
            return CalculatorFactory.create(clazz)
        }

        /**
         * 使用自定义计算器
         *
         * @param T
         * @param C
         * @param clazz
         * @return
         */
        @JvmStatic
        fun <T : Number ,C : ICalculator<T>> asCustom(clazz: Class<C>): C {
            return clazz.newInstance()
        }

    }


}