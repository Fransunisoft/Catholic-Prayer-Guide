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


public class Otherprayer extends ActionBarActivity {
    private ArrayAdapter<String> mForecastAdapter;
    private PrayerGuideDBHelper prayerGuideDBHelper;
    SharedPreference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherprayer);
        pref = new SharedPreference(Otherprayer.this);
        prayerGuideDBHelper = new PrayerGuideDBHelper(Otherprayer.this);
        String[] forecastArray = {
                "Christmas Anticipation Prayer",
                "Episcopal Blessing",
                "Intercession Of Pope John Paul II",
                "Miscarriage Prayer",
                "Morning Offering",
                "Prayer After Mass",
                "Prayer Before Mass",
                "Prayer Of Employment",
                "Prayer For Our President and Public Officials",
                "Prayer For Help Against Spiritual Enemies",
                "Prayer For Life",
                "Prayer For Life Throughout The Year",
                "Prayer For The Unborn",
                "Prayer For Travelers",
                "Prayer For Vocations",
                "Short Prayer",
                "Thanksgiving For Mass"
        };

        List<String> weekForecast;
        weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray));

        mForecastAdapter =
                new ArrayAdapter<String>(
                        Otherprayer.this,
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview,
                        weekForecast);

        ListView listView = (ListView) findViewById(
                R.id.list_other_prayer);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String christmasanticipationprayertittle = prayerGuideDBHelper.ChristmasAnticipationPrayerTittle();
                        String christmasanticipationprayer = prayerGuideDBHelper.ChristmasAnticipationPrayer();
                        Intent intent = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(christmasanticipationprayertittle, christmasanticipationprayer);
                        startActivity(intent);
                        break;
                    case 1:
                        String episcopalblessingtittle = prayerGuideDBHelper.EpiscopalBlessingTittle();
                        String episcopalblessing = prayerGuideDBHelper.EpiscopalBlessing();
                        Intent intent1 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(episcopalblessingtittle, episcopalblessing);
                        startActivity(intent1);
                        break;
                    case 2:
                        String intercessionofpopejohnpaulIItittle = prayerGuideDBHelper.IntercessionOfPopeJohnPaulIITittle();
                        String intercessionofpopejohnpaulII = prayerGuideDBHelper.IntercessionOfPopeJohnPaulII();
                        Intent intent2 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(intercessionofpopejohnpaulIItittle, intercessionofpopejohnpaulII);
                        startActivity(intent2);
                        break;
                    case 3:
                        String miscarriageprayertittle = prayerGuideDBHelper.MiscarriagePrayerTittle();
                        String miscarriageprayer = prayerGuideDBHelper.MiscarriagePrayer();
                        Intent intent3 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(miscarriageprayertittle, miscarriageprayer);
                        startActivity(intent3);
                        break;
                    case 4:
                        String morningofferingtittle = prayerGuideDBHelper.MorningOfferingTittle();
                        String morningoffering = prayerGuideDBHelper.MorningOffering();
                        Intent intent4 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(morningofferingtittle, morningoffering);
                        startActivity(intent4);
                        break;
                    case 5:
                        String prayeraftermasstittle = prayerGuideDBHelper.PrayerAfterMassTittle();
                        String prayeraftermass = prayerGuideDBHelper.PrayerAfterMass();
                        Intent intent5 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayeraftermasstittle, prayeraftermass);
                        startActivity(intent5);
                        break;
                    case 6:
                        String prayerbeforemasstittle = prayerGuideDBHelper.PrayerBeforeMassTittle();
                        String prayerbeforemass = prayerGuideDBHelper.PrayerBeforeMass();
                        Intent intent6 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerbeforemasstittle, prayerbeforemass);
                        startActivity(intent6);
                        break;
                    case 7:
                        String prayerformploymenttittle = prayerGuideDBHelper.PrayerForEmploymentTittle();
                        String prayerformployment = prayerGuideDBHelper.PrayerForEmployment();
                        Intent intent7 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerformploymenttittle, prayerformployment);
                        startActivity(intent7);
                        break;
                    case 8:
                        String prayerforourpresidentandpublicofficialstittle = prayerGuideDBHelper.PrayerForOurPresidentAndPublicOfficialsTittle();
                        String prayerforourpresidentandpublicofficials = prayerGuideDBHelper.PrayerForOurPresidentAndPublicOfficials();
                        Intent intent8 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerforourpresidentandpublicofficialstittle, prayerforourpresidentandpublicofficials);
                        startActivity(intent8);
                        break;
                    case 9:
                        String prayerforhelpagainstspiritualenemiestittle = prayerGuideDBHelper.PrayerForHelpAgainstSpiritualEnemiesTittle();
                        String prayerforhelpagainstspiritualenemies = prayerGuideDBHelper.PrayerForHelpAgainstSpiritualEnemies();
                        Intent intent9 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerforhelpagainstspiritualenemiestittle, prayerforhelpagainstspiritualenemies);
                        startActivity(intent9);
                        break;
                    case 10:
                        String prayerforlifetittle = prayerGuideDBHelper.PrayerForLifeTittle();
                        String prayerforlife = prayerGuideDBHelper.PrayerForLife();
                        Intent intent10 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerforlifetittle, prayerforlife);
                        startActivity(intent10);
                        break;
                    case 11:
                        String prayerforlifethroughouttheyeartittle = prayerGuideDBHelper.PrayerForLifeThroughoutTheYearTittle();
                        String prayerforlifethroughouttheyear = prayerGuideDBHelper.PrayerForLifeThroughoutTheYear();
                        Intent intent11 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerforlifethroughouttheyeartittle, prayerforlifethroughouttheyear);
                        startActivity(intent11);
                        break;
                    case 12:
                        String prayerfortheunborntittle = prayerGuideDBHelper.PrayerForTheUnbornTittle();
                        String prayerfortheunborn = prayerGuideDBHelper.PrayerForTheUnborn();
                        Intent intent12 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerfortheunborntittle, prayerfortheunborn);
                        startActivity(intent12);
                        break;
                    case 13:
                        String prayerfortravelerstittle = prayerGuideDBHelper.PrayerForTravelersTittle();
                        String prayerfortravelers = prayerGuideDBHelper.PrayerForTravelers();
                        Intent intent13 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerfortravelerstittle, prayerfortravelers);
                        startActivity(intent13);
                        break;
                    case 14:
                        String prayerforvocationstittle = prayerGuideDBHelper.PrayerForVocationsTittle();
                        String prayerforvocations = prayerGuideDBHelper.PrayerForVocations();
                        Intent intent14 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(prayerforvocationstittle, prayerforvocations);
                        startActivity(intent14);
                        break;
                    case 15:
                        String shortprayertittle = prayerGuideDBHelper.ShortPrayerTittle();
                        String shortprayer = prayerGuideDBHelper.ShortPrayer();
                        Intent intent15 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(shortprayertittle, shortprayer);
                        startActivity(intent15);
                        break;
                    case 16:
                        String thanksgivingaftermasstittle = prayerGuideDBHelper.ThanksgivingAfterMassTittle();
                        String thanksgivingaftermass = prayerGuideDBHelper.ThanksgivingAfterMass();
                        Intent intent16 = new Intent (Otherprayer.this, Prayer.class);
                        pref.savePrayer(thanksgivingaftermasstittle, thanksgivingaftermass);
                        startActivity(intent16);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_otherprayer, menu);
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
            Intent aboutintent = new Intent(Otherprayer.this, About.class);
            startActivity (aboutintent);
        }


        return super.onOptionsItemSelected(item);
    }
}

