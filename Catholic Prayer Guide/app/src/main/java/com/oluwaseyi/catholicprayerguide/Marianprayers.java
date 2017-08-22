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


public class Marianprayers extends ActionBarActivity {
    private ArrayAdapter<String> mForecastAdapter;
    private PrayerGuideDBHelper prayerGuideDBHelper;
    SharedPreference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marianprayers);
        pref = new SharedPreference(Marianprayers.this);
        prayerGuideDBHelper = new PrayerGuideDBHelper(Marianprayers.this);
        String[] forecastArray = {
                "Children's Prayer To Mary",
                "Don Bosco's Prayer To Mary",
                "Election Prayer To Mary",
                "In Honor Of The Immaculate Conception",
                "Magnificant",
                "Memorare",
                "Our Lady Of Perpetual Help",
                "Pope's Immaculate Conception Prayer",
                "Prayer To Our Lady Lourdes",
                "Regina Coeli"
        };

        List<String> weekForecast;
        weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray));

        mForecastAdapter =
                new ArrayAdapter<String>(
                        Marianprayers.this,
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview,
                        weekForecast);

        ListView listView = (ListView) findViewById(
                R.id.list_marian_prayers);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String childrensprayertomarytittle = prayerGuideDBHelper.ChildrensPrayerToMaryTittle();
                        String childrensprayertomary = prayerGuideDBHelper.ChildrensPrayerToMary();
                        Intent intent = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(childrensprayertomarytittle, childrensprayertomary);
                        startActivity(intent);
                        break;
                    case 1:
                        String donboscosprayertomarytittle = prayerGuideDBHelper.DonBoscosPrayerToMaryTittle();
                        String donboscosprayertomary = prayerGuideDBHelper.DonBoscosPrayerToMary();
                        Intent intent1 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(donboscosprayertomarytittle, donboscosprayertomary);
                        startActivity(intent1);
                        break;
                    case 2:
                        String electionprayertomarytittle = prayerGuideDBHelper.ElectionPrayerToMaryTittle();
                        String electionprayertomary = prayerGuideDBHelper.ElectionPrayerToMary();
                        Intent intent2 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(electionprayertomarytittle, electionprayertomary);
                        startActivity(intent2);
                        break;
                    case 3:
                        String inhonoroftheimmaculateconceptiontittle = prayerGuideDBHelper.InHonorOfTheImmaculateConceptionTittle();
                        String inhonoroftheimmaculateconception = prayerGuideDBHelper.InHonorOfTheImmaculateConception();
                        Intent intent3 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(inhonoroftheimmaculateconceptiontittle, inhonoroftheimmaculateconception);
                        startActivity(intent3);
                        break;
                    case 4:
                        String magnificanttittle = prayerGuideDBHelper.MagnificantTittle();
                        String magnificant = prayerGuideDBHelper.Magnificant();
                        Intent intent4 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(magnificanttittle, magnificant);
                        startActivity(intent4);
                        break;
                    case 5:
                        String memorraretittle = prayerGuideDBHelper.MemorrareTittle();
                        String memorrare = prayerGuideDBHelper.Memorrare();
                        Intent intent5 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(memorraretittle, memorrare);
                        startActivity(intent5);
                        break;
                    case 6:
                        String ourladyofperpetualhelptittle = prayerGuideDBHelper.OurLadyOfPerpetualHelpTittle();
                        String ourladyofperpetualhelp = prayerGuideDBHelper.OurLadyOfPerpetualHelp();
                        Intent intent6 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(ourladyofperpetualhelptittle, ourladyofperpetualhelp);
                        startActivity(intent6);
                        break;
                    case 7:
                        String popesimmaculateconceptionprayertittle = prayerGuideDBHelper.PopesImmaculateConceptionPrayerTittle();
                        String popesimmaculateconceptionprayer = prayerGuideDBHelper.PopesImmaculateConceptionPrayer();
                        Intent intent7 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(popesimmaculateconceptionprayertittle, popesimmaculateconceptionprayer);
                        startActivity(intent7);
                        break;
                    case 8:
                        String prayertoourladyoflourdestittle = prayerGuideDBHelper.PrayerToOurLadyOfLourdesTittle();
                        String prayertoourladyoflourdes = prayerGuideDBHelper.PrayerToOurLadyOfLourdes();
                        Intent intent8 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(prayertoourladyoflourdestittle, prayertoourladyoflourdes);
                        startActivity(intent8);
                        break;
                    case 9:
                        String reginacoelitittle = prayerGuideDBHelper.ReginaCoeliTittle();
                        String reginacoeli = prayerGuideDBHelper.ReginaCoeli();
                        Intent intent9 = new Intent (Marianprayers.this, Prayer.class);
                        pref.savePrayer(reginacoelitittle, reginacoeli);
                        startActivity(intent9);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_marianprayers, menu);
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
            Intent aboutintent = new Intent(Marianprayers.this, About.class);
            startActivity (aboutintent);
        }

        return super.onOptionsItemSelected(item);
    }


}
