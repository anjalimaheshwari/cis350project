package com.example.personalwellness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class CreateAccountActivity extends AppCompatActivity {

    private ResourceDB database;
    private EditText nameET, usernameET, passwordET;
    private Button backButton, registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        database = (ResourceDB) getIntent().getSerializableExtra("database");
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

                User u = new User(nameString, usernameString, passwordString);
                database.addUser(u);
                Intent i = new Intent(CreateAccountActivity.this,
                        HomeActivity.class);
                i.putExtra("accountNum", u.getAccountNum());
                i.putExtra("database", database);
                startActivity(i);
            }
        });

    }
}