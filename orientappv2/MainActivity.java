package com.example.orientappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button click;
    private Button ttt;
    private Button proclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click=findViewById(R.id.clicker);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Clicker.class);
                startActivity(intent);
            }
        });
        ttt=findViewById(R.id.ttt);
        ttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Tic_Tac_Toe.class);
                startActivity(intent);
            }
        });

        proclick=findViewById(R.id.proClicker);
        proclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProClicker.class);
                startActivity(intent);
            }
        });
    }
}