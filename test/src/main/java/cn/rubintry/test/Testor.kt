package cn.rubintry.test

class Testor {

    companion object{
        private val str = "abc-2123qwer-0.123"


        inline fun <reified T: Number> getNumber(){
            print(T::class.java.simpleName)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            getNumber<Int>()
        }
    }
}