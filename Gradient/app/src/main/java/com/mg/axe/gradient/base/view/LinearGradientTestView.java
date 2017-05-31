package com.mg.axe.gradient.base.view;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/26.
 */

public class LinearGradientTestView extends View {

    private Paint mPaint;
    private LinearGradient mLinearGradient;

    public LinearGradientTestView(Context context) {
        this(context,null);
    }

    public LinearGradientTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LinearGradientTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLinearGradient = new LinearGradient(0,500,500,500,new int[]{Color.RED,Color.BLUE,Color.GRAY,Color.GREEN},null, Shader.TileMode.MIRROR);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mPaint.setShader(mLinearGradient);
        canvas.drawRect(0, 0, 800, 800, mPaint);
    }
}
