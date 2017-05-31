package com.mg.axe.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author Name
 * @Create 2017/5/31 0031
 * @Description Content
 */

public class RadarView extends View {

    private Paint mPaint;
    private SweepGradient mSweepGradient;

    private Matrix matrix;
    private int mWidth = 0;

    private RectF rectF;

    private int lineDistance;

    /**
     * 旋转的角度
     **/
    private int degree = 0;

    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mWidth = ScreenUtils.getScreenWidth(context)[0];

        lineDistance = mWidth / 2 / 2;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        matrix = new Matrix();

        mSweepGradient = new SweepGradient(
                mWidth / 2, mWidth / 2, new int[]{Color.TRANSPARENT, Color.parseColor("#41CC00")}, null);

        rectF = new RectF();


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        for (int i = 0; i < 2; i++) {
            rectF.top = 10 + i * lineDistance;
            rectF.left = 10 + i * lineDistance;
            rectF.bottom = (mWidth - 10) - i * lineDistance;
            rectF.right = (mWidth - 10) - +i * lineDistance;

            //先画圆圈
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10);
            mPaint.setColor(Color.parseColor("#05E60B"));
            canvas.drawArc(rectF, 0, 360, false, mPaint);
        }

        //画点
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(15);
        canvas.drawPoint(mWidth / 2, mWidth / 2, mPaint);

        //画扫描框
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShader(mSweepGradient);
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2 - 5, mPaint);

        mPaint.reset();
        //使用Matrix旋转
        mSweepGradient.setLocalMatrix(matrix);
        matrix.setRotate(degree, mWidth / 2, mWidth / 2);
        degree++;
        if (degree > 360) {
            degree = 0;
        }
        postInvalidate();
    }
}
