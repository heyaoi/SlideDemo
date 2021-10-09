package com.example.slidedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TestListView extends ListView {
    private float mLastYIntercept;
    public TestListView(Context context) {
        super(context);
    }

    public TestListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float y = ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                if (getFirstVisiblePosition() == 0 && (y - mLastYIntercept) > 0){
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else if (getLastVisiblePosition() == getCount()-1 && (y - mLastYIntercept) < 0){
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            }
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        mLastYIntercept = y;

        return super.dispatchTouchEvent(ev);
    }
}
