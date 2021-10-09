package com.example.slidedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

public class TestScrollerView extends ScrollView {
    private float mLastYIntercept;

    public TestScrollerView(Context context) {
        super(context);
    }

    public TestScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        if (ev.getAction() == MotionEvent.ACTION_DOWN){
            return false;
        } else {
            return true;
        }
    }

    /* @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);

        boolean intercepted = false;
        float y = ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                intercepted = false;
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                ListView listView = (ListView) ((ViewGroup)getChildAt(0)).getChildAt(1);
                if (listView.getLastVisiblePosition() == listView.getCount()-1 && (y - mLastYIntercept) < 0){
                    intercepted = true;
                } else if (listView.getFirstVisiblePosition() == 0 && (y - mLastYIntercept) > 0){
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                intercepted = false;
                break;
            }
            default:
                break;
        }

        mLastYIntercept = y;
        return intercepted;
    }*/
}
