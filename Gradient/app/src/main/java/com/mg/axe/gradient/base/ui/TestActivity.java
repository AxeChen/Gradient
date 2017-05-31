package com.mg.axe.gradient.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mg.axe.gradient.R;
import com.mg.axe.gradient.base.view.BitmapShaderTestView;
import com.mg.axe.gradient.base.view.ComposeShaderTestView;
import com.mg.axe.gradient.base.view.LinearGradientTestView;
import com.mg.axe.gradient.base.view.RadialGradientTestView;
import com.mg.axe.gradient.base.view.SweepGradientTestView;

/**
 * Created by Administrator on 2017/6/1.
 */

public class TestActivity extends AppCompatActivity {

    public static final int TYPE_BITMAPSHADER = 0;
    public static final int TYPE_LINEARgRADIENT = 0;
    public static final int TYPE_RADIALGRADIENT = 0;
    public static final int TYPE_SWEEPGRADIENT = 0;
    public static final int TYPE_COMPOSESHADER = 0;


    private BitmapShaderTestView bitmapShaderTestView;
    private LinearGradientTestView linearGradientTestView;
    private RadialGradientTestView radialGradientTestView;
    private SweepGradientTestView sweepGradientTestView;
    private ComposeShaderTestView composeShaderTestView;

    private TextView tvType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bitmapShaderTestView = (BitmapShaderTestView) findViewById(R.id.bitmapShader);
        linearGradientTestView = (LinearGradientTestView) findViewById(R.id.linearGradient);
        radialGradientTestView = (RadialGradientTestView) findViewById(R.id.radialGradient);
        sweepGradientTestView = (SweepGradientTestView) findViewById(R.id.sweepGradient);
        composeShaderTestView = (ComposeShaderTestView) findViewById(R.id.composeShader);
        tvType = (TextView) findViewById(R.id.tvType);

        tvType.setText("BitmapShader");
        bitmapShaderTestView.setVisibility(View.VISIBLE);
        linearGradientTestView.setVisibility(View.GONE);
        radialGradientTestView.setVisibility(View.GONE);
        sweepGradientTestView.setVisibility(View.GONE);
        composeShaderTestView.setVisibility(View.GONE);
    }

    public void showBitmapShader(View view){
        tvType.setText("BitmapShader");
        bitmapShaderTestView.setVisibility(View.VISIBLE);
        linearGradientTestView.setVisibility(View.GONE);
        radialGradientTestView.setVisibility(View.GONE);
        sweepGradientTestView.setVisibility(View.GONE);
        composeShaderTestView.setVisibility(View.GONE);
    }

    public void showLinearGradient(View view){
        tvType.setText("LinearGradient");
        bitmapShaderTestView.setVisibility(View.GONE);
        linearGradientTestView.setVisibility(View.VISIBLE);
        radialGradientTestView.setVisibility(View.GONE);
        sweepGradientTestView.setVisibility(View.GONE);
        composeShaderTestView.setVisibility(View.GONE);
    }

    public void showRadialGradient(View view){
        tvType.setText("RadialGradient");
        bitmapShaderTestView.setVisibility(View.GONE);
        linearGradientTestView.setVisibility(View.GONE);
        radialGradientTestView.setVisibility(View.VISIBLE);
        sweepGradientTestView.setVisibility(View.GONE);
        composeShaderTestView.setVisibility(View.GONE);
    }

    public void showSweepGradient(View view){
        tvType.setText("SweepGradient");
        bitmapShaderTestView.setVisibility(View.GONE);
        linearGradientTestView.setVisibility(View.GONE);
        radialGradientTestView.setVisibility(View.GONE);
        sweepGradientTestView.setVisibility(View.VISIBLE);
        composeShaderTestView.setVisibility(View.GONE);
    }

    public void showComposeShader(View view){
        tvType.setText("ComposeShader");
        bitmapShaderTestView.setVisibility(View.GONE);
        linearGradientTestView.setVisibility(View.GONE);
        radialGradientTestView.setVisibility(View.GONE);
        sweepGradientTestView.setVisibility(View.GONE);
        composeShaderTestView.setVisibility(View.VISIBLE);
    }
}
