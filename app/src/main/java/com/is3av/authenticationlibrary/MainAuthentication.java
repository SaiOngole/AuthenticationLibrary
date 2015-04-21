package com.is3av.authenticationlibrary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;


public class MainAuthentication extends ActionBarActivity {

    String root = android.os.Environment.getExternalStorageDirectory().toString();
    File mydir = new File(root+"/authentication");
    String filename = "authentication.txt";
    String path = mydir + File.separator + filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean exists = (new File(path)).exists();

        if(!exists) {
            File file = new File(mydir+File.separator+filename);
            Toast.makeText(this,"Taking you to the training screen", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainAuthentication.this, TrainingActivity.class);
            startActivity(intent);
        }
        else {
            setContentView(R.layout.activity_main_authentication);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_authentication, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
