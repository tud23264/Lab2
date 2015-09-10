package com.example.tud23264.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colors = {"Please select a color.", "red", "blue", "green", "orange","yellow","purple"};

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, colors);
        Spinner mySpinner=(Spinner)findViewById(R.id.mySpinner);

        mySpinner.setAdapter(stringArrayAdapter);



    }

    @Override
    protected void onStart() {
        super.onStart();
        final Spinner mySpinner=(Spinner)findViewById(R.id.mySpinner);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                boolean firstTime = true;
                Intent launchActivityIntent = new Intent(MainActivity.this, MainActivity2.class);
                launchActivityIntent.putExtra("color", mySpinner.getSelectedItem().toString());
                //Toast.makeText(MainActivity.this,  mySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show(); //FOR TESTING


                if (mySpinner.getSelectedItemPosition() != 0)
                    startActivity(launchActivityIntent);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // nothing to be put in here, but the listener requires it
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
