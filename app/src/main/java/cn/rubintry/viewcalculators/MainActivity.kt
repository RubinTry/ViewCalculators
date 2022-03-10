package cn.rubintry.viewcalculators

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import cn.rubintry.calculator.ViewCalculator
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var tvParam1: TextView ?= null
    private var tvParam2: TextView ?= null
    private var tvResult: TextView ?= null
    private var tvResult2: TextView ?= null
    private var btnGotoJava: Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvParam1 = findViewById(R.id.tv_param1)
        tvParam2 = findViewById(R.id.tv_param2)
        tvResult = findViewById(R.id.tv_result)
        tvResult2 = findViewById(R.id.tv_result2)
        btnGotoJava = findViewById(R.id.btn_goto_java)

        btnGotoJava?.setOnClickListener(this)

//        /**
//         * 基本用法
//         */
//        ViewCalculator.with(Int::class.java)
//            .add(1000.6)
//            .divide(3 , 6)
//            .appendUnit("元")
//            .into(tvResult , tvResult2)



//        /**
//         * 自定义
//         */
//        ViewCalculator.asCustom(BigDecimalCalculator::class.java)
//            .add(tvParam1)
//            .subtract(tvParam2)
//            .multiply(tvParam1)
//            .divide(123 , 2)
//            .appendUnit("元")
//            .into(tvResult , tvResult2)

        /**
         * 获取结果以便做其他处理
         */
        val result = ViewCalculator.with(BigDecimal::class.java)
            .add(tvParam1)
            .subtract(tvParam2)
            .multiply(tvParam1)
            .appendUnit("元")
            .into(tvResult , tvResult2)
            .toString()

        println("result: $result")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_goto_java -> {
                startActivity(Intent(this , MainActivity2::class.java))
            }
        }
    }
}