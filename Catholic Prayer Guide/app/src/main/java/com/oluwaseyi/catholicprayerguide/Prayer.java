package com.oluwaseyi.catholicprayerguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class Prayer extends ActionBarActivity {
    SharedPreference pref;
    TextView prayer_txt, prayertitle_txt;
    public static String strprayer, prayer_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);
        pref = new SharedPreference(Prayer.this);
        prayer_txt = (TextView) findViewById(R.id.tvPrayers);
        prayertitle_txt = (TextView) findViewById(R.id.tvPrayersTitle);
        //hashmap to get use detailsprayer
        HashMap<String, String> prayer = pref.getPrayerDetails();
        strprayer = prayer.get(pref.KEY_PRAYER);
        prayer_title = prayer.get(pref.KEY_TITLE);

        prayer_txt.setText(strprayer);
        prayertitle_txt.setText(prayer_title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prayer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_about){
            Intent aboutintent = new Intent(Prayer.this, About.class);
            startActivity (aboutintent);
            return true;
        }
        if (id == R.id.action_share){
            Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, prayer_title);
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,"I have just used Catholic Prayer Guide." + " " + "Download Catholic Prayer Guide at http://play.Google.com/store/apps/details?Id=com.oluwaseyi.catholicprayerguide");
            startActivity(Intent.createChooser(shareIntent, "Share via"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
