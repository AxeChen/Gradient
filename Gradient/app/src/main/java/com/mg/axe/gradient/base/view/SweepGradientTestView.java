package com.mg.axe.gradient.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/30.
 */

public class SweepGradientTestView extends View {

    private Paint mPaint;
    private SweepGradient mSweepGradient;

    public SweepGradientTestView(Context context) {
        this(context, null);
    }

    public SweepGradientTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SweepGradientTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mSweepGradient = new SweepGradient(250, 250, new int[]{Color.GREEN, Color.YELLOW, Color.RED}, null);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(mSweepGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShader(mSweepGradient);
        canvas.drawCircle(250, 250, 250, mPaint);
    }
}
