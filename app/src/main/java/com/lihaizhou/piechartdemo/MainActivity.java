package com.lihaizhou.piechartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private PieChartView pieChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fruitNames[] = {"苹果","橙子","香蕉","桃子","草莓"};
        int fruitSums[] = {10,15,20,8,30};
        final PieDataBean pieDataBean = new PieDataBean(fruitNames,fruitSums);
        pieChartView = (PieChartView) findViewById(R.id.pie);
        pieChartView.setData(pieDataBean);
    }
}
