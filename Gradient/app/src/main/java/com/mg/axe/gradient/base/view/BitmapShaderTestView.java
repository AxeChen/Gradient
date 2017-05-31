package com.mg.axe.gradient.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mg.axe.gradient.R;

/**
 * Created by Chen on 2017/5/25.
 * BitmapShader测试类
 */

public class BitmapShaderTestView extends View {

    private Paint mPaint;
    private BitmapShader mBitmapShader;
    private Bitmap mBitmap;

    public BitmapShaderTestView(Context context) {
        this(context, null);
    }

    public BitmapShaderTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapShaderTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy1);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(mBitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        canvas.drawRect(0, 0, 800, 800, mPaint);
    }
}
