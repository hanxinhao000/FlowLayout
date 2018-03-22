package com.example.xinhao_han.xhflowlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FlowLayout flowLayout;
    private Button btn;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIUtils.init(this);
        setContentView(R.layout.activity_main);
        flowLayout = findViewById(R.id.flowLayout);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(this);

        random = new Random();



    }

    @Override
    public void onClick(View v) {

        TextView textView = new TextView(this);

        textView.setTextColor(Color.parseColor("#161616"));
        textView.setText(" " + random.nextInt(Integer.MAX_VALUE) +"测试 ");

        flowLayout.addView(textView);



    }
}
