package com.android.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button checkThemeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroups);
        checkThemeBtn = findViewById(R.id.checkTheme);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                if (id == R.id.system){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }else if (id == R.id.light){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }else if (id == R.id.night){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

            }
        });


        checkThemeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkSystemTheme();
            }
        });




    }


    private void checkSystemTheme(){

        Configuration configuration = getApplicationContext().getResources().getConfiguration();
        int currentConfiguration = configuration.uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (currentConfiguration){
            case Configuration.UI_MODE_NIGHT_NO:
                Toast.makeText(this, "System is using light mode", Toast.LENGTH_SHORT).show();
                break;

            case Configuration.UI_MODE_NIGHT_YES:
                Toast.makeText(this, "System is using night mode", Toast.LENGTH_SHORT).show();
        }
    }


}