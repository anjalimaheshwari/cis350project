package com.example.personalwellness;

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
                String usernameString = usernameET.getText().toString();
                String passwordString = passwordET.getText().toString();
                String user = getUser(usernameString);
                Log.d(TAG, "----------- got username " + user);
                //User curr = AsyncClient.getCurrentUser();
                User curr = CurrentUser.getCurrentUser(AsyncClient.getCurrentUser()); //singleton instance of who the current user is

                curr.updateAccountNum(AsyncClient.accountNum);
                curr.updateStress(AsyncClient.stress);
                curr.updatePhysicalHealth(AsyncClient.physicalHealth);
                curr.updateMentalHealth(AsyncClient.mentalHealth);
                curr.updateCommunity(AsyncClient.community);

                Log.d(TAG, "----------- name " + curr.getName());
                Log.d(TAG, "----------- username " + curr.getUserName());
                Log.d(TAG, "----------- ph " + curr.getPhysicalHealth());
                Log.d(TAG, "----------- stress " + curr.getStress());
                Log.d(TAG, "----------- community " + curr.getCommunity());
                Log.d(TAG, "----------- accountNum " + curr.getAccountNum());
                Log.d(TAG, "----------- mh " + curr.getMentalHealth());

                //User u = checkValidUser(usernameString, passwordString);
                if (checkValidUser(passwordString, curr.getPassword())) {
                    Intent i = new Intent(MainActivity.this,
                            HomeActivity.class);
                    i.putExtra("accountNum", curr.getAccountNum());
                    startActivity(i);
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
            URL url = new URL("http://10.0.2.2:3000/person?username=" + username);
            AsyncTask<URL, String, String> task = new AsyncClient();
            task.execute(url);
            String name = task.get();
            return name;
        } catch (Exception e) {
            return e.toString();
        }
    }
}