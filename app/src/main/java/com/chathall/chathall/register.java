package com.chathall.chathall;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

/**
 * Created by Smit on 18/8/15.
 */
public class register extends ActionBarActivity {

  EditText username,password,email;
    String username_s,password_s,email_s;
  //  Button login,register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_signup);
        getSupportActionBar().hide();

        //username = (EditText) findViewById(R.id.login_username);
        //password = (EditText) findViewById(R.id.login_password);
        //login = (Button) findViewById(R.id.login_submit);
        //register = (Button) findViewById(R.id.login_register);


    }
    public void checking_register(View v){
        email = (EditText) findViewById(R.id.register_email);
        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        int pass_length = password.getText().length();
        email_s =   email.getText().toString().trim();
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
        else if(email.getText().toString().trim().equals(""))
        {
            email.setError("Please provide description");
        }
        else if(pass_length<6){

            password.setError("Minimum length should be 6 characters long");
        }
        else{

            ParseUser user = new ParseUser();
            user.setUsername(username_s);
            user.setPassword(password_s);
            user.setEmail(email_s);
            //other fields
            //user.put("Country",country);

            user.signUpInBackground();
            Toast.makeText(register.this,"Added",Toast.LENGTH_SHORT).show();
        }


    }

}
