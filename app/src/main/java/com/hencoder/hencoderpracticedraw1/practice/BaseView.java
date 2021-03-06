package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class BaseView extends View {
    protected Paint mPaint;

    public BaseView(Context context) {
        super(context);
        init();
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
}
