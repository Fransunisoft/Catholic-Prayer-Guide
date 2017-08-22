package com.oluwaseyi.catholicprayerguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Button basicprayer;
    Button prayertojesus;
    Button marianprayers;
    Button prayerofthesaint;
    Button otherprayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basicprayer = (Button)findViewById(R.id.button);
        prayertojesus = (Button)findViewById(R.id.button2);
        marianprayers = (Button)findViewById(R.id.button3);
        prayerofthesaint = (Button)findViewById(R.id.button4);
        otherprayers = (Button)findViewById(R.id.button5);

        basicprayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Basicprayers.class);

                startActivity(i);


            }
        });

        prayertojesus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PrayertoJesus.class);

                startActivity(i);
            }
        });

        marianprayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Marianprayers.class);

                startActivity(i);
            }
        });


        prayerofthesaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Prayerofthesaint.class);

                startActivity(i);
            }
        });

        otherprayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Otherprayer.class);

                startActivity(i);
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
        // Handle action bar item clicks here.qbSC The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about){
            Intent about = new Intent(MainActivity.this, About.class);
            startActivity(about);
        }



        return super.onOptionsItemSelected(item);
    }
}
















































































































































































































































