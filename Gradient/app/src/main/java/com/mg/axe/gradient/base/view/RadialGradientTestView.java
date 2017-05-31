package com.mg.axe.gradient.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/30.
 */

public class RadialGradientTestView extends View {

    private Paint mPaint;
    private RadialGradient mRadialGradient;

    public RadialGradientTestView(Context context) {
        this(context, null);
    }

    public RadialGradientTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadialGradientTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mRadialGradient = new RadialGradient(250, 250, 250, new int[]{Color.RED, Color.GREEN, Color.BLACK}, null, Shader.TileMode.CLAMP);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShader(mRadialGradient);
        canvas.drawCircle(250, 250, 250, mPaint);
    }
}
