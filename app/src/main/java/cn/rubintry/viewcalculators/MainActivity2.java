package cn.rubintry.viewcalculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResult = findViewById(R.id.tv_result);
        ViewCalculator.with(BigDecimal.class)
                .add("123")
                .subtract("23")
                .multiply("100.01" , 2)
                .divide("3" , 2)
                .into(tvResult);
    }
}