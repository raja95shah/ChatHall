package com.chathall.chathall;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView listView3;
    String names[] = {"Smit","Palak","Chetan","Priya"};
    List<ParseObject> ob;
    ListAdapter adapter;
    String [] list1Strings22 = new String [0];
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list1Strings22 = new ArrayList<String>();
        listView3 = (ListView) findViewById(R.id.listView);

        //



        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("chat");
        query.orderByDescending("_created_at");

        try {
            ob = query.find();
            if(ob.size()>0){


            }
        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.activity_main);
// Retrieve object "name" from Parse.com database
        int iii=0;
        if(ob.size()>0) {
            for (ParseObject chat : ob) {

                list1Strings22.set(iii, (String) chat.get("receiver"));
                iii++;
            }
            listView3.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list1Strings22));
// Binds the Adapter to the ListView

            listView3.setAdapter(adapter);
        }
        else{

            listView3.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,names));
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final Context context = this;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

        }
       else if (id == R.id.profile) {
            Intent intent = new Intent(context, profile.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
