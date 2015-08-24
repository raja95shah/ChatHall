package com.chathall.chathall;

/**
 * Created by Smit on 18/8/15.
 */
import android.app.Application;
import android.content.Intent;

import  com.parse.Parse;
import com.parse.ParseUser;

public class chatApp extends Application {


    public void onCreate(){


        super.onCreate();
        Parse.initialize(this,"vSUsqwr32NpHWUe1Xsb4mxl7w8k32vrkgnFppAsr","YoM1ANHXwEBjxxYlsIZ5CSu9PmOo1NP5KOFOcPyh");




    }

}
