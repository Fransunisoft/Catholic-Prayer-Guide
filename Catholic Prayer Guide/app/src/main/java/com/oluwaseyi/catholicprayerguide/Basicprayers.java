package com.oluwaseyi.catholicprayerguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Basicprayers extends ActionBarActivity {
    private ArrayAdapter<String> mForecastAdapter;
    private PrayerGuideDBHelper prayerGuideDBHelper;
    SharedPreference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicprayers);
        pref = new SharedPreference(Basicprayers.this);
        prayerGuideDBHelper = new PrayerGuideDBHelper(Basicprayers.this);
        String[] forecastArray = {
                "Angelus Prayers",
                "Apostle's Creed",
                "Glory Be",
                "Guardian Angel Prayer",
                "Hail Mary",
                "Holy Rosary",
                "Our Father",
                "St Micheal the Archangel"
        };

        List<String> weekForecast;
        weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray));

        mForecastAdapter =
                new ArrayAdapter<String>(
                        Basicprayers.this,
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview,
                        weekForecast);

        ListView listView = (ListView) findViewById(
                R.id.list_basic_prayer);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String angelustittle = prayerGuideDBHelper.AngelusPrayersTittle();
                        String angelus = prayerGuideDBHelper.AngelusPrayers();
                        Intent intent = new Intent (Basicprayers.this, Prayer.class);
                        pref.savePrayer(angelustittle, angelus);
                        startActivity(intent);
                        break;
                    case 1:
                        String apostlescreedtittle = prayerGuideDBHelper.ApostlesCreedTittle();
                        String apostlescreed = prayerGuideDBHelper.ApostlesCreed();
                        Intent intent1 = new Intent (Basicprayers.this, Prayer.class);
                        pref.savePrayer(apostlescreedtittle, apostlescreed);
                        startActivity(intent1);
                        break;
                    case 2:
                        String glorybetittle = prayerGuideDBHelper.GlorybeTittle();
                        String glorybe = prayerGuideDBHelper.Glorybe();
                        Intent intent2 = new Intent (Basicprayers.this, com.oluwaseyi.catholicprayerguide.Prayer.class);
                        pref.savePrayer(glorybetittle, glorybe);
                        startActivity(intent2);
                        break;
                    case 3:
                        String guardianangeltittle = prayerGuideDBHelper.GuardianAngelTittle();
                        String guardianangel = prayerGuideDBHelper.GuardianAngel();
                        Intent intent3 = new Intent (Basicprayers.this, com.oluwaseyi.catholicprayerguide.Prayer.class);
                        pref.savePrayer(guardianangeltittle, guardianangel);
                        startActivity(intent3);
                        break;
                    case 4:
                        String hailmarytittle = prayerGuideDBHelper.HailMaryTittle();
                        String hailmary = prayerGuideDBHelper.HailMary();
                        Intent intent4 = new Intent (Basicprayers.this, com.oluwaseyi.catholicprayerguide.Prayer.class);
                        pref.savePrayer(hailmarytittle, hailmary);
                        startActivity(intent4);
                        break;
                    case 5:
                        String holyrosarytittle = prayerGuideDBHelper.HolyRosaryTittle();
                        String holyrosary = prayerGuideDBHelper.HolyRosary();
                        Intent intent5 = new Intent (Basicprayers.this, com.oluwaseyi.catholicprayerguide.Prayer.class);
                        pref.savePrayer(holyrosarytittle, holyrosary);
                        startActivity(intent5);
                        break;
                    case 6:
                        String ourfathertittle = prayerGuideDBHelper.OurFatherTittle();
                        String ourfather = prayerGuideDBHelper.OurFather();
                        Intent intent6 = new Intent (Basicprayers.this, com.oluwaseyi.catholicprayerguide.Prayer.class);
                        pref.savePrayer(ourfathertittle, ourfather);
                        startActivity(intent6);
                        break;
                    case 7:
                        String stmichealthearchangeltittle = prayerGuideDBHelper.StMichealTheArchangelTittle();
                        String stmichealthearchangel = prayerGuideDBHelper.StMichealTheArchangel();
                        Intent intent7 = new Intent (Basicprayers.this, com.oluwaseyi.catholicprayerguide.Prayer.class);
                        pref.savePrayer(stmichealthearchangeltittle, stmichealthearchangel);
                        startActivity(intent7);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basicprayers, menu);
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
            Intent aboutintent = new Intent(Basicprayers.this, About.class);
            startActivity (aboutintent);
        }
        return super.onOptionsItemSelected(item);
    }

}
