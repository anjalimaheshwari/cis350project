package com.example.personalwellness;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button capsButton = (Button) findViewById(R.id.mentalhealth);
        capsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(MainActivity.this,CAPSPage.class);
                startActivity(int1);
            }
        });

        Button dietButton = (Button) findViewById(R.id.diet);
        dietButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this,DietPage.class);
                startActivity(int2);
            }
        });


        Button stressButton = (Button) findViewById(R.id.stress);
        stressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(MainActivity.this,StressPage.class);
                startActivity(int3);
            }
        });


        Button fitnessButton = (Button) findViewById(R.id.fitness);
        fitnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(MainActivity.this,FitnessPage.class);
                startActivity(int4);
            }
        });

        Button sleepButton = (Button) findViewById(R.id.sleep);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(MainActivity.this,SleepPage.class);
                startActivity(int5);
            }
        });

        Button communityButton = (Button) findViewById(R.id.community);
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(MainActivity.this,CommunityPage.class);
                startActivity(int6);
            }
        });
    }
}
