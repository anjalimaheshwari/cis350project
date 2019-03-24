package com.example.personalwellness;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ResourceDB database;
    private EditText usernameET, passwordET;
    private Button loginButton, createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new ResourceDB();
        usernameET = (EditText) findViewById(R.id.usernameEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        createAccountButton = (Button) findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = usernameET.getText().toString();
                String passwordString = passwordET.getText().toString();
                User u = checkValidUser(usernameString, passwordString);
                if (u != null) {
                    Intent i = new Intent(MainActivity.this,
                            SurveyActivity.class);
                    i.putExtra("accountNum", u.getAccountNum());
                    startActivity(i);
                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this,
                        CreateAccountActivity.class);
                i2.putExtra("database", database);
                startActivity(i2);
            }
        });

    }

    private User checkValidUser(String username, String password) {
        for (User u : database.getUserDB()) {
            if (u.getUserName().equals(username) && u.isPassword(password)) {
                return u;
            }
        }
        return null;
    }
}