package com.example.personalwellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GriefReferralPage extends AppCompatActivity {
    ResourceDB resourceDB = new ResourceDB();
    List<Resource> resources = resourceDB.getResourceList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grief_referral_page);
        ImageView imgSetDynamic;
        String extra = getIntent().getStringExtra("buttonid");
        TextView textV = (TextView) findViewById(R.id.griefRef);
        TextView textAbout = (TextView) findViewById(R.id.resourceabout);

        for (int i = 0; i < resources.size(); i++) {
            if (extra.equals((i+1)+"")) {
                textV.setText(resources.get(i).getName());
                textAbout.setText(resources.get(i).getSummary());
            }
        }

    }
}
