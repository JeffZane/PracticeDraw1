package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends BaseView {

    private RectF mRectF;
    private List<Model> mArray;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();

        mRectF = new RectF(200, 100, 700, 600);

        mArray = new ArrayList<>();
        mArray.add(new Model("Froyo", 1.1f, Color.TRANSPARENT));
        mArray.add(new Model("Gingerbread", 2.4f, Color.RED));
        mArray.add(new Model("Ice Cream Sandwich", 2.4f, Color.GRAY));
        mArray.add(new Model("Jelly Bean", 15, Color.GREEN));
        mArray.add(new Model("KitKat", 27, Color.BLUE));
        mArray.add(new Model("Lollipop", 32, Color.CYAN));
        mArray.add(new Model("Marshmallow", 17, Color.YELLOW));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        mPaint.setStyle(Paint.Style.FILL);
        int totalAngle = 0;
        boolean hasOffset = false;
        for (Model model : mArray) {
            mPaint.setColor(model.color);
            if ("Lollipop".equals(model.name)) {
                mRectF.offset(-10, -10);
                hasOffset = true;
            }

            int angle = (int) (model.percent * 3.6);
            canvas.drawArc(mRectF, totalAngle, angle, true, mPaint);
            totalAngle += angle + 3;

            if (hasOffset) {
                mRectF.offset(10, 10);
                hasOffset = false;
            }
        }
//
//        canvas.drawArc(mRectF, 0, -45, true, mPaint);
//
//        mRectF.offset(-10, -10);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawArc(mRectF, -60, -110, true, mPaint);
//
//        mRectF.offset(10, 10);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawArc(mRectF, -190, -110, true, mPaint);
//
//        mPaint.setColor(Color.CYAN);
//        canvas.drawArc(mRectF, 0, 15, true, mPaint);
//
//        mPaint.setColor(Color.MAGENTA);
//        canvas.drawArc(mRectF, 20, 38, true, mPaint);
//
//        mPaint.setColor(Color.RED);
//        canvas.drawArc(mRectF, 45, 80, true, mPaint);
    }

    class Model {
        String name;
        float percent;
        int color;

        Model(String name, float percent, int color) {
            this.name = name;
            this.percent = percent;
            this.color = color;
        }
    }
}
