package com.chathall.chathall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

/**
 * Created by Smit on 20/8/15.
 */
public class loading extends ActionBarActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_xml);

        Intent intent;

        if(ParseUser.getCurrentUser() == null){
            intent = new Intent(this, login.class);
        }else{
            intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
        this.finish();

    }


}
