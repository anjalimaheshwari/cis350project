package com.example.personalwellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String extra = getIntent().getStringExtra("maxScore");
        Log.d("-----------------max Score", extra);

        Button capsButton = (Button) findViewById(R.id.mentalhealth);
        capsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(HomeActivity.this,CAPSPage.class);
                startActivity(int1);
            }
        });

        Button dietButton = (Button) findViewById(R.id.diet);
        dietButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(HomeActivity.this,DietPage.class);
                startActivity(int2);
            }
        });


        Button stressButton = (Button) findViewById(R.id.stress);
        stressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(HomeActivity.this,StressPage.class);
                startActivity(int3);
            }
        });


        Button fitnessButton = (Button) findViewById(R.id.fitness);
        fitnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(HomeActivity.this,FitnessPage.class);
                startActivity(int4);
            }
        });

        Button sleepButton = (Button) findViewById(R.id.sleep);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(HomeActivity.this,SleepPage.class);
                startActivity(int5);
            }
        });

        Button communityButton = (Button) findViewById(R.id.community);
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(HomeActivity.this,CommunityPage.class);
                startActivity(int6);
            }
        });

        Button recsButton = (Button) findViewById(R.id.recommendations);
        recsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int7 = new Intent(HomeActivity.this,RecsPage.class);
                int7.putExtra("maxCategory", extra);
                Log.d("------------extra", extra);
                startActivity(int7);
            }
        });
    }
}
