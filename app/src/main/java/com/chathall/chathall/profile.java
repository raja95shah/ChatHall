package com.chathall.chathall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.ParseException;

/**
 * Created by Smit on 20/8/15.
 */
public class profile extends ActionBarActivity {

    EditText username, password,email;
    Button logout;
    String username_s, password_s,email_s,objectid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_user);
        username = (EditText) findViewById(R.id.profile_username);
        password = (EditText) findViewById(R.id.profile_password);
        email = (EditText) findViewById(R.id.profile_email);
        logout = (Button) findViewById(R.id.user_logout);
        assign();
        username.setText(username_s);
        password.setText("Hidden");
        email.setText(email_s);

        final Context context1 = this;
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent intent = new Intent(context1, loading.class);
                startActivity(intent);
            }


            //Intent intent = new Intent(context, firstpage.class);
            //startActivity(intent);

        });





    }
    private void assign(){


        final Context context = this;
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            username_s = currentUser.getUsername();
            email_s = currentUser.getEmail();
            objectid = currentUser.getObjectId();

        } else {
            Intent intent = new Intent(context, loading.class);
            startActivity(intent);
        }

    }
    void update_personal(){




    }

    public void update_profile(View v){
       username = (EditText) findViewById(R.id.profile_username);
        email = (EditText) findViewById(R.id.profile_email);
        email_s =   email.getText().toString().trim();
        username_s = username.getText().toString().trim();
        final Context context = this;
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            currentUser.setUsername(username_s);
            currentUser.setEmail(email_s);


        }
        Toast.makeText(profile.this,"Profile Updated",Toast.LENGTH_SHORT).show();




    }


}
