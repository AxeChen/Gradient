package com.mg.axe.gradient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mg.axe.gradient.base.ui.TestActivity;
import com.mg.axe.gradient.simple.activity.ControlActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void baseUse(View view) {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }

    public void simpleUse(View view) {
        Intent intent = new Intent(MainActivity.this, ControlActivity.class);
        startActivity(intent);
    }
}
