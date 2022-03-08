package cn.rubintry.viewcalculators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private var str = "sfdfffsd-123bddsdas-123sadasd0.23"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCalculator.with(BigDecimal::class.java)


            .into()

    }
}