package com.idletimetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Mohanraj.S,innobot-linux-4 on 7/6/17.
 */

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout userName;
        private TextInputLayout password;
        private View btnLogin;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            userName = (TextInputLayout) findViewById(R.id.username_field);
            password = (TextInputLayout) findViewById(R.id.pass_field);
            btnLogin = findViewById(R.id.btn_login);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userName.getEditText().getText().toString().trim().equals("")) {
                        Toast.makeText(LoginActivity.this, "Please input your user name", Toast.LENGTH_SHORT).show();
                    } else if (password.getEditText().getText().toString().trim().equals("")) {
                        Toast.makeText(LoginActivity.this, "Please input your password", Toast.LENGTH_SHORT).show();
                    } else if (userName.getEditText().getText().toString().equals("mohan") &&
                            password.getEditText().getText().toString().equals("123")) {
                        //Correct user name and password, go to main screen
                        Intent intent = new Intent(LoginActivity.this, IdealTimeActivity_POC_1.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong input data", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
