package com.example.personalwellness;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ResourceDB database;
    private EditText usernameET, passwordET;
    private Button loginButton, createAccountButton;
    public String usernameString;
    public String passwordString;

    private static final String TAG = MainActivity.class.getSimpleName();

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
                usernameString = usernameET.getText().toString();
                passwordString = passwordET.getText().toString();

                CurrentUser curr = CurrentUser.getCurrentUser();

                // this will populate the singleton user class
                getUser(usernameString);

                if (curr.getUserName() == null) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Invalid username or password");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {

                    if (checkValidUser(passwordString, curr.getPassword())) {
                        Intent i = new Intent(MainActivity.this,
                                HomeActivity.class);
                        i.putExtra("accountNum", curr.getAccountNum());
                        startActivity(i);
                    } else {
                        Log.d(TAG, "----------- mh " + curr.getPassword());

                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("Invalid username or password");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }

            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this,
                        CreateAccountActivity.class);
                Log.d(TAG, "Got here in Main");
                startActivity(i2);
            }
        });

    }

    private boolean checkValidUser(String inputPassword, String truePassword) {
        if (truePassword.equals(inputPassword)) {
            Log.d(TAG, "----------- good pw");
            return true;
        }
        return false;
    }

    public static String getUser(String username) {
        try {
            Log.d(TAG, "----------- entering main activity get user ");
            URL url = new URL("http://10.0.2.2:3001/person?username=" + username);
            AsyncTask<URL, String, String> task = new AsyncClient();
            task.execute(url);
            String name = task.get();
            return name;
        } catch (Exception e) {
            return e.toString();
        }
    }
}