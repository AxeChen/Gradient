package com.mg.axe.gradient.simple.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mg.axe.gradient.R;

/**
 * Created by Chen on 2017/6/1.
 */

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
    }

    public void showRoundImage(View view){
        Intent intent = new Intent(ControlActivity.this,RoundImageActivity.class);
        startActivity(intent);
    }

    public void showRadarView(View view){
        Intent intent = new Intent(ControlActivity.this,RadarViewActivity.class);
        startActivity(intent);
    }

    public void showWaveView(View view){
        Intent intent = new Intent(ControlActivity.this,WaveViewActivity.class);
        startActivity(intent);
    }

    public void showGradientView(View view){
        Intent intent = new Intent(ControlActivity.this,GradientTextActivity.class);
        startActivity(intent);
    }
}
