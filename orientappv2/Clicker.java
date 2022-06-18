package com.example.orientappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clicker extends AppCompatActivity {

    TextView tv_t,tv_c;
    Button b_c, b_s,r;

    CountDownTimer timer;
    int time = 15;

    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        tv_t = (TextView) findViewById(R.id.tv_time);
        tv_c = (TextView) findViewById(R.id.tv_click);
        b_c = (Button) findViewById(R.id.click);
        b_s = (Button) findViewById(R.id.startGame);
        r = (Button) findViewById(R.id.reset);

        b_s.setEnabled(true);
        b_c.setEnabled(false);
        r.setEnabled(false);

        timer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time --;
                tv_t.setText("Time: "+time);
            }

            @Override
            public void onFinish() {
                b_s.setEnabled(true);
                b_c.setEnabled(false);
                r.setEnabled(true);
            }
        };

        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks ++;
                tv_c.setText("Clicks: "+clicks);
            }
        });

        b_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                b_s.setEnabled(false);
                b_c.setEnabled(true);
                r.setEnabled(false);
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               time = 15;
               clicks = 0;
                tv_t.setText("Time: "+time);
                tv_c.setText("Clicks: "+clicks);
                b_s.setEnabled(true);
                b_c.setEnabled(false);
            }
        });

    }

}