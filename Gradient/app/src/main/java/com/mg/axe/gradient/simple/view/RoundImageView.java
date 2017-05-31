package com.mg.axe.gradient.simple.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mg.axe.gradient.R;

/**
 * @Author Chen
 * @Create 2017/5/31 0031
 */

public class RoundImageView extends View {

    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;

    private Paint mPaint;

    private RectF rect;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy2);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        rect = new RectF();
        rect.left = 0;
        rect.top = mBitmap.getHeight();
        rect.bottom = mBitmap.getHeight() * 2;
        rect.right = mBitmap.getWidth();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShader(mBitmapShader);
        canvas.drawCircle(mBitmap.getWidth() / 2, mBitmap.getWidth() / 2, mBitmap.getWidth() / 2, mPaint);

        canvas.drawOval(rect, mPaint);
    }
}
