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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrayertoJesus extends ActionBarActivity {
    private ArrayAdapter<String> mForecastAdapter;
    private PrayerGuideDBHelper prayerGuideDBHelper;
    SharedPreference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayerto_jesus);
        pref = new SharedPreference(PrayertoJesus.this);
        prayerGuideDBHelper = new PrayerGuideDBHelper(PrayertoJesus.this);
        String[] forecastArray = {

                "Act Of Spiritual Communion",
                "Anima Christi",
                "Christ Candle Of Hope prayer",
                "Holy Face",
                "Novena To The Divine Child Jesus",
                "Sacred Heart",
                "Thanksgiving To The Trinity"
        };

        List<String> weekForecast;
        weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray));

        mForecastAdapter =
                new ArrayAdapter<String>(
                       PrayertoJesus.this,
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview,
                        weekForecast);

        ListView listView = (ListView) findViewById(
                R.id.list_prayer_jesus);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String actofspiritualcommuniontittle = prayerGuideDBHelper.ActOfSpiritualCommunionTittle();
                        String actofspiritualcommunion = prayerGuideDBHelper.ActOfSpiritualCommunion();
                        Intent intent = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(actofspiritualcommuniontittle, actofspiritualcommunion);
                        startActivity(intent);
                        break;
                    case 1:
                        String animachristitittle = prayerGuideDBHelper.AnimaChristiTittle();
                        String animachristi = prayerGuideDBHelper.AnimaChristi();
                        Intent intent1 = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(animachristitittle, animachristi);
                        startActivity(intent1);
                        break;
                    case 2:
                        String christcandleofhopeprayertittle = prayerGuideDBHelper.ChristCandleOfHopePrayerTittle();
                        String christcandleofhopeprayer = prayerGuideDBHelper.ChristCandleOfHopePrayer();
                        Intent intent2 = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(christcandleofhopeprayertittle, christcandleofhopeprayer);
                        startActivity(intent2);
                        break;
                    case 3:
                        String holyfacetittle = prayerGuideDBHelper.HolyFaceTittle();
                        String holyface = prayerGuideDBHelper.HolyFace();
                        Intent intent3 = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(holyfacetittle, holyface);
                        startActivity(intent3);
                        break;
                    case 4:
                        String novenatothedivinechildjesustittle = prayerGuideDBHelper.NovenaToTheDivineChildJesusTittle();
                        String novenatothedivinechildjesus = prayerGuideDBHelper.NovenaToTheDivineChildJesus();
                        Intent intent4 = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(novenatothedivinechildjesustittle, novenatothedivinechildjesus);
                        startActivity(intent4);
                        break;
                    case 5:
                        String sacredhearttittle = prayerGuideDBHelper.SacredHeartTittle();
                        String sacredheart = prayerGuideDBHelper.SacredHeart();
                        Intent intent5 = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(sacredhearttittle, sacredheart);
                        startActivity(intent5);
                        break;
                    case 6:
                        String thanksgivingtothetrinitytittle = prayerGuideDBHelper.ThanksgivingToTheTrinityTittle();
                        String thanksgivingtothetrinity = prayerGuideDBHelper.ThanksgivingToTheTrinity();
                        Intent intent6 = new Intent (PrayertoJesus.this, Prayer.class);
                        pref.savePrayer(thanksgivingtothetrinitytittle, thanksgivingtothetrinity);
                        startActivity(intent6);
                        break;
                }
        }
    });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prayerto_jesus, menu);
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
            Intent aboutintent = new Intent(PrayertoJesus.this, About.class);
            startActivity (aboutintent);
        }


        return super.onOptionsItemSelected(item);
    }

}
