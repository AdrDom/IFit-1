package com.example.rosemberg.ifit.listeners;

import android.content.Intent;
import android.view.View;

import com.example.rosemberg.ifit.activities.EntrarNutri;
import com.example.rosemberg.ifit.activities.MainActivity;

public class EntrarNutriOnClick implements View.OnClickListener{
    private MainActivity mainActivity;

    public EntrarNutriOnClick(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mainActivity, EntrarNutri.class);
        mainActivity.startActivity(intent);
    }
}
