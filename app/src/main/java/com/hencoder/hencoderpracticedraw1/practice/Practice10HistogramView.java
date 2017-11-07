package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends BaseView {

    private static final int COUNT = 7;

    private static final int X_START = 150;
    private static final int X_END = 800;
    private static final int Y_START = 100;
    private static final int Y_END = 600;

    private static final int COLUMNAR_WIDTH = 80;
    private static final int INTERVAL = 30;

    private Path mPath;
    private List<RectF> mRectFs;
    private List<String> mStrings;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();

        mPath = new Path();
        mPath.moveTo(X_START, Y_START);
        mPath.lineTo(X_START, Y_END);
        mPath.rLineTo(X_END, 0);

        mRectFs = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            int left = X_START + ((i + 1) * INTERVAL) + i * COLUMNAR_WIDTH;
            int right = left + COLUMNAR_WIDTH;
            mRectFs.add(new RectF(left, getColumnarHeight(), right, Y_END));
        }

        mStrings = new ArrayList<>();
        mStrings.add("Froyo");
        mStrings.add("GB");
        mStrings.add("ICS");
        mStrings.add("JB");
        mStrings.add("KitKat");
        mStrings.add("L");
        mStrings.add("M");
    }

    private int getColumnarHeight() {
        return (int) (Math.random() * (Y_END - Y_START - 20)) + Y_START; // Y_START ~ (Y_END - 20)
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // X、Y轴
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
//        canvas.drawLine(100, 50, 100, 600, mPaint);
//        canvas.drawLine(100, 600, 800, 600, mPaint);
        canvas.drawPath(mPath, mPaint);

        // 矩形、文字
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(24);
        for (int i = 0; i < COUNT; i++) {
            mPaint.setColor(Color.GREEN);
            canvas.drawRect(mRectFs.get(i), mPaint);

            mPaint.setColor(Color.WHITE);
            // TODO: param.x/y? 相对居中?
            canvas.drawText(mStrings.get(i), mRectFs.get(i).left, mRectFs.get(i).bottom + 30, mPaint);
        }
    }
}
