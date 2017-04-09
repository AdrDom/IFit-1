package com.example.rosemberg.ifit.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.rosemberg.ifit.R;

public class SplashScreen extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, 4000);
    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}