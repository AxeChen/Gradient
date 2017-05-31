package com.mg.axe.gradient.simple.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;

/**
 * Created by Chen on 2017/5/21.
 */

public class GradientTextView extends android.support.v7.widget.AppCompatTextView {

    private LinearGradient mLinearGradient;
    private TextPaint mPaint;

    private Matrix mMatrix;

    private float mTranslate;
    private float DELTAX = 20;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = getPaint();
        mMatrix = new Matrix();

        String text = getText().toString();

        float textWith = mPaint.measureText(text);
        // 确定文字的宽度
        int gradientSize = (int) (textWith / text.length() * 3);

        mLinearGradient = new LinearGradient(0, 0, gradientSize, 0, new int[]{
                0x22ffffff, 0xffffffff, 0x22ffffff}, null, Shader.TileMode.CLAMP
        );

        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //实现轮播效果
        mTranslate += DELTAX;
        float textWidth = getWidth();
        if (mTranslate > textWidth -50 || mTranslate < 1) {
            DELTAX = -DELTAX;
        }
        //移动渐变
        mMatrix.setTranslate(mTranslate, 0);
        mLinearGradient.setLocalMatrix(mMatrix);
        postInvalidateDelayed(50);
    }
}
