package com.example.personalwellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class RecsPage extends AppCompatActivity {

    ResourceDB resourceDB = new ResourceDB();
    //List<Resource> resources = resourceDB.getResourceList();
    Proc proc = new Proc(resourceDB);
    List<Resource> recommentations = proc.getRecs(CurrentUser.getCurrentUser(null));
    Button[] button = new Button[recommentations.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_page);

        ConstraintLayout ll = (ConstraintLayout) findViewById(R.id.constraint_layout);

        for (int i = 0; i < recommentations.size(); i++) {
            button[i] = new Button(this);
            button[i].setId(i+1);
            button[i].setText(recommentations.get(i).getName());
            ll.addView(button[i],
                    new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT));
        }

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(ll);

        for (int i = 0; i < recommentations.size()-1; i++) {
            if (button[i] != null) {
                constraintSet.connect(button[i].getId(), ConstraintSet.TOP, button[i+1].getId(),
                        ConstraintSet.BOTTOM);
            }
        }

        constraintSet.applyTo(ll);

        for (int i = 0; i < button.length; i++) {
            if (button[i] != null) {
                button[i] = (Button) findViewById(button[i].getId());
                final int b = button[i].getId();
                button[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RecsPage.this,
                                GriefReferralPage.class);
                        intent.putExtra("buttonid", b + "");
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
