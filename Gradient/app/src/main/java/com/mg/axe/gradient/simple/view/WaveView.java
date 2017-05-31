package com.mg.axe.gradient.simple.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @Author Chen
 * @Create 2017/5/31 0031
 */

public class WaveView extends View {

    private Paint mPaint;
    private RadialGradient mRadialGradient;

    /**
     * 按下时的的大小
     */
    private static final int DEFAULT_FIRST_CLICK_RADIUS = 50;


    /**
     * 最大的半徑
     */
    private static final int DEFAULT_MOST_RADIUS = 400;


    private int mRadius = 0;

    /**
     * 按下去的X坐标
     */
    private int cX = 0;

    /**
     * 按下去时Y的坐标
     */
    private int cY = 0;

    /**
     * 是否触发UP
     */
    private boolean isUP = false;

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(cX,cY,mRadius,mPaint);
        if(isUP){
            mRadius+=20;
        }
        //渐变的圆圈是否到达最大值
        if(mRadius> DEFAULT_MOST_RADIUS){
            isUP = false;
            //设置mRadius为0圆圈就会消失了
            mRadius = 0;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                cX = (int) event.getX();
                cY = (int) event.getY();
                //点击时画第一个小圆
                setGradient();
                isUP = false;
                break;
            case MotionEvent.ACTION_UP:
                isUP = true;
                break;
        }

        return true;
    }


    private void setGradient(){
        mRadius = DEFAULT_FIRST_CLICK_RADIUS;
        mRadialGradient = new RadialGradient(cX, cY, mRadius, new int[]{Color.parseColor("#F0F0F0"), Color.parseColor("#F0F0F0")}, null, Shader.TileMode.CLAMP);
        mPaint.setShader(mRadialGradient);
        invalidate();
    }


}
