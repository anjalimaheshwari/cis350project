package com.example.personalwellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SurveyActivity extends AppCompatActivity {

    private TempSurvey mSurvey = new TempSurvey();

    private TextView mQuestionNumberView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mPrev;
    private int mQuestionNumber = 0;

    private static final String TAG = SurveyActivity.class.getSimpleName();

    private HashMap<Integer, String> surveyResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        surveyResponses = new HashMap<Integer, String>();

        mQuestionNumberView = (TextView) findViewById(R.id.question_number);
        mQuestionView = (TextView) findViewById(R.id.question);

        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mPrev = (Button) findViewById(R.id.previous_question);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surveyResponses.put(mQuestionNumber, mButtonChoice1.getText().toString());
                updateQuestion();
                Log.d(TAG, "-----------answer choice 1, question answer: " + mButtonChoice1.getText().toString());
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surveyResponses.put(mQuestionNumber, mButtonChoice2.getText().toString());
                updateQuestion();
                Log.d(TAG, "-----------answer choice 2, question answer: " + mButtonChoice2.getText().toString());
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surveyResponses.put(mQuestionNumber, mButtonChoice3.getText().toString());
                updateQuestion();
                Log.d(TAG, "-----------answer choice 3, question answer: " + mButtonChoice3.getText().toString());
            }
        });
        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousQuestion();
                Log.d(TAG, "-----------previous question");
            }
        });

    }

    private void updateQuestion() {
        if (mSurvey.checkQuestionAvailable(mQuestionNumber)) {
            mQuestionView.setText(mSurvey.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mSurvey.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mSurvey.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mSurvey.getChoice3(mQuestionNumber));
            mQuestionNumberView.setText(mQuestionNumber + "");
            mQuestionNumber++;
        } else {
            User curr = CurrentUser.getCurrentUser(null);
            //analysis of survey answers
            //these are dummy values! 
            int stress = 9;
            int sleep = 10;
            int mentalHealth = 5;
            int community = 3;
            int ph = 4;
            curr.updateStress(stress);
            curr.updateSleep(sleep);
            curr.updateMentalHealth(mentalHealth);
            curr.updateCommunity(community);
            curr.updatePhysicalHealth(ph);
            //add here for the Async stuff!
            Intent i = new Intent(SurveyActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }

    private void previousQuestion() {
        if (mQuestionNumber > 0) {
            mQuestionNumber--;
            mQuestionNumberView.setText(mQuestionNumber + "");
            mQuestionView.setText(mSurvey.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mSurvey.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mSurvey.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mSurvey.getChoice3(mQuestionNumber));
        }
    }

    public void createUser(User user) {

    }
}
