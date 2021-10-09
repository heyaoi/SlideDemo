package com.example.slidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSlide,btnConflict;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }



    private void init(){
         btnSlide = findViewById(R.id.btnSlide);
         btnConflict = findViewById(R.id.btnConflict);


         btnSlide.setOnClickListener(this);
         btnConflict.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnSlide:
                intent = new Intent(MainActivity.this,SlideActivity.class);
                break;
            case R.id.btnConflict:
                intent = new Intent(MainActivity.this,ConflictActivity.class);
                break;
            default:
        }
        startActivity(intent);
    }
}