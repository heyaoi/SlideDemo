package com.example.slidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTo,btnBy,btn;
    LinearLayout linearLayout;
    TextView textView;
    int mLastX=0;
    int mLastY=0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        init();

        btn = findViewById(R.id.btn);

        textView = findViewById(R.id.tv);


        btn.setOnTouchListener((v, event) -> {
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    int deltaX = x - mLastX;
                    int deltaY = y - mLastY;

                    int translationX = (int) (v.getTranslationX() + deltaX);
                    int translationY = (int) (v.getTranslationY() + deltaY);

                    v.setTranslationX(translationX);
                    v.setTranslationY(translationY);

                    textView.setText("x: "+x+"   y: "+y);
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:break;

            }

            mLastX = x;
            mLastY = y;

            return true;
        });
    }



    private void init(){
        linearLayout = findViewById(R.id.linearlayout);
        btnTo = findViewById(R.id.btnTo);
        btnBy = findViewById(R.id.btnBy);



        btnTo.setOnClickListener(this);
        btnBy.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnTo:
                linearLayout.scrollTo(-60,-100);
                break;
            case R.id.btnBy:
                linearLayout.scrollBy(-60,-100);
                break;
            default:
        }
    }
}