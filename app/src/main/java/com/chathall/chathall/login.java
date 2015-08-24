package com.chathall.chathall;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Smit on 18/8/15.
 */
public class login extends ActionBarActivity {

    EditText username,password;
    Button login,register;
    String username_s,password_s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signin);
        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
         username_s = username.getText().toString().trim();
         password_s = password.getText().toString().trim();
        //login = (Button) findViewById(R.id.login_submit);
        register = (Button) findViewById(R.id.login_register);
        final Context context = this;
        View.OnClickListener oclBtnOk2 = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // change text of the TextView (tvOut)

                Intent intent = new Intent(context, register.class);
                startActivity(intent);

            }
        };


        register.setOnClickListener(oclBtnOk2);

    }
    public void checking_login(View v){
        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        int pass_length = password.getText().length();

        username_s = username.getText().toString().trim();
        password_s = password.getText().toString().trim();
        if(username.getText().toString().trim().equals(""))
        {
            username.setError("Please provide description");
        }
        else if(password.getText().toString().trim().equals(""))
        {
            password.setError("Please provide description");
        }
        else if(pass_length<6){

            password.setError("Minimum length should be 6 characters long");
        }
        else{

            adding();

        }

    }
    private void adding(){

       // Toast toast = Toast.makeText(login.this,"Added",Toast.LENGTH_SHORT);
       // toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
       // toast.show();
        final Context context = this;
        ParseUser.logInInBackground(username_s, password_s, new LogInCallback() {
            public void done(final ParseUser user, ParseException e) {
                if (user != null) {
                    String objectId = user.getObjectId();
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);

                }
                else{

                    Toast toast = Toast.makeText(login.this,"LoginFaid",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                    toast.show();

                }
            }

        });
    }

}

