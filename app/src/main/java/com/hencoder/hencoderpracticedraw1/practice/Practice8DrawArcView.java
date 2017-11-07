package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class Practice8DrawArcView extends BaseView {

    private RectF mRectF;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        mRectF = new RectF(200, 100, 800, 400);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        // startAngle: 是弧形的起始角度（以X轴正向为参考线，顺时针为正角度，逆时针为负角度）
        // sweepAngle: 是弧形划过的角度
        // useCenter: 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形

        // 弧形
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mRectF, -130, -60, false, mPaint);

        // 弧形2
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(mRectF, 20, 140, false, mPaint);

        // 扇形
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(mRectF, -120, 100, true, mPaint);
    }
}
