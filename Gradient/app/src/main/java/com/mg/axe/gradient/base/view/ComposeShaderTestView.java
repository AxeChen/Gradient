package com.mg.axe.gradient.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mg.axe.gradient.R;

/**
 * Created by Chen on 2017/5/31.
 */

public class ComposeShaderTestView extends View {

    private ComposeShader composeShader;

    //位图渲染
    private BitmapShader mBitmapShader;
    private Bitmap mBitmap;

    //线性渲染
    private LinearGradient mLinearGradient;

    private Paint mPaint;

    public ComposeShaderTestView(Context context) {
        this(context, null);
    }

    public ComposeShaderTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComposeShaderTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy2);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        mLinearGradient = new LinearGradient(0, mBitmap.getHeight(), mBitmap.getWidth(), mBitmap.getHeight(), new int[]{Color.RED, Color.BLUE, Color.GRAY, Color.GREEN}, null, Shader.TileMode.MIRROR);

        //组合渲染
        composeShader = new ComposeShader(mBitmapShader, mLinearGradient, PorterDuff.Mode.MULTIPLY);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShader(composeShader);
        canvas.drawRect(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), mPaint);
    }
}
