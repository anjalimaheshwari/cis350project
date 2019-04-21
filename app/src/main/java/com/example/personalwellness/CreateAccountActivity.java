package com.example.personalwellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.io.Serializable;

public class CreateAccountActivity extends AppCompatActivity {

    private ResourceDB database;
    private EditText nameET, usernameET, passwordET;
    private Button backButton, registerButton;
    private TextView errorTV;
    final Context context = this;
    private Button alertButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Log.d("Yaw", "Got here in CreateAccount");


        errorTV = (TextView) findViewById(R.id.caErrorText);
        nameET = (EditText) findViewById(R.id.caNameEditText);
        usernameET = (EditText) findViewById(R.id.caUsernameEditText);
        passwordET = (EditText) findViewById(R.id.caPasswordEditText);
        backButton = (Button) findViewById(R.id.caBackButton);
        registerButton = (Button) findViewById(R.id.caRegisterButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = nameET.getText().toString();
                String usernameString = usernameET.getText().toString();
                String passwordString = passwordET.getText().toString();
                Log.d("Yaw", "pw " + passwordString + " pw");
                if (passwordString == null || usernameString == null || nameString == null ||
                passwordString.equals("") || usernameString.equals("") || nameString.equals("")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(CreateAccountActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Please fill all fields");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                String takenUsername = MainActivity.getUser(usernameString);
                if (takenUsername == null || takenUsername.equals("")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(CreateAccountActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Username is taken");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    User u = new User(nameString, usernameString, passwordString);
                    CurrentUser.getCurrentUser(u);
                    Intent i = new Intent(CreateAccountActivity.this,
                            SurveyActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}