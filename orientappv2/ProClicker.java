package com.example.orientappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProClicker extends AppCompatActivity {

    Button b_s,b_c1,b_c2;
    TextView tv_t,tv_c;
    int numOrClick = 0;
    int secLeft = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_clicker);

        b_s = (Button) findViewById(R.id.start);
        b_c1 = (Button) findViewById(R.id.click1);
        b_c2 = (Button) findViewById(R.id.click2);

        tv_c = (TextView) findViewById(R.id.tv_click);
        tv_t = (TextView) findViewById(R.id.tv_time);

        b_s.setEnabled(true);
        b_c1.setEnabled(false);
        b_c2.setEnabled(false);

        final CountDownTimer timer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secLeft--;
                tv_t.setText("Second left: "+secLeft);
            }

            @Override
            public void onFinish() {
                b_c2.setEnabled(false);
                b_c1.setEnabled(false);
                b_s.setEnabled(true);
            }
        };
        b_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secLeft=15;
                numOrClick = 0;
                b_c1.setEnabled(true);
                b_c2.setEnabled(false);
                b_s.setEnabled(false);
                timer.start();
            }
        });

        b_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOrClick++;
                tv_c.setText("Number of clicks: "+numOrClick);
                b_c2.setEnabled(true);
                b_c1.setEnabled(false);
            }
        });

        b_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOrClick++;
                tv_c.setText("Number of clicks: "+numOrClick);
                b_c1.setEnabled(true);
                b_c2.setEnabled(false);
            }
        });

    }
}