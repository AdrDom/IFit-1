package com.example.rosemberg.ifit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.rosemberg.ifit.R;
import com.example.rosemberg.ifit.listeners.EntrarNutriOnClick;

public class MainActivity extends AppCompatActivity {
    private Button btnNutri;
    private Button btnAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNutri = (Button) findViewById(R.id.btnNutri);
        btnAluno = (Button) findViewById(R.id.btnAluno);

        btnNutri.setOnClickListener(new EntrarNutriOnClick(this));
        btnAluno.setOnClickListener(new EntrarNutriOnClick(this));
    }
}
