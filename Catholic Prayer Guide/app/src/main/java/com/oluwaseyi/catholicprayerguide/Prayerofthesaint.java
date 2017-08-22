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


public class Prayerofthesaint extends ActionBarActivity {
    private ArrayAdapter<String> mForecastAdapter;
    private PrayerGuideDBHelper prayerGuideDBHelper;
    SharedPreference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayerofthesaint);
        pref = new SharedPreference(Prayerofthesaint.this);
        prayerGuideDBHelper = new PrayerGuideDBHelper(Prayerofthesaint.this);
        String[] forecastArray = {
                "Devotion To St. Joseph",
                "Lorica Of St. Patrick",
                "Memorare To St. Joseph",
                "Saint Augustine Of Hippo",
                "Saint Benedict of Nursia",
                "Saint Bonaventure",
                "Saint Cecilia",
                "Saint Clare Of Assisi",
                "Saint Ephrem",
                "Saint Faustina's Prayer Before Eucharist",
                "Saint Francis Of Assisi",
                "Saint Ignatuis Prayer Against Depression",
                "Saint Joseph",
                "Saint Mary Magdalene",
                "Saint Micheal The Archangel",
                "Saint Pio Prayer Of Trust And Confidence",
                "Saint Teresa Of Avila Prayer",
                "Saint Therese Of Lisieux",
                "Saint Thomas Aquinas"

        };

        List<String> weekForecast;
        weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray));

        mForecastAdapter =
                new ArrayAdapter<String>(
                        Prayerofthesaint.this,
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview,
                        weekForecast);

        ListView listView = (ListView) findViewById(
                R.id.list_prayer_saint);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String devotiontostjosephtittle = prayerGuideDBHelper.DevotionToStJosephTittle();
                        String devotiontostjoseph = prayerGuideDBHelper.DevotionToStJoseph();
                        Intent intent = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(devotiontostjosephtittle, devotiontostjoseph);
                        startActivity(intent);
                        break;
                    case 1:
                        String loricaofstpatricktittle = prayerGuideDBHelper.LoricaOfStPatrickTittle();
                        String loricaofstpatrick = prayerGuideDBHelper.LoricaOfStPatrick();
                        Intent intent1 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(loricaofstpatricktittle, loricaofstpatrick);
                        startActivity(intent1);
                        break;
                    case 2:
                        String memorareofstjosephtittle = prayerGuideDBHelper.MemorareOfStJosephTittle();
                        String memorareofstjoseph = prayerGuideDBHelper.MemorareOfStJoseph();
                        Intent intent2 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(memorareofstjosephtittle, memorareofstjoseph);
                        startActivity(intent2);
                        break;
                    case 3:
                        String staugustineofhippotittle = prayerGuideDBHelper.StAugustineOfHippoTittle();
                        String staugustineofhippo = prayerGuideDBHelper.StAugustineOfHippo();
                        Intent intent3 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(staugustineofhippotittle, staugustineofhippo);
                        startActivity(intent3);
                        break;
                    case 4:
                        String stbenedictofnursiatittle = prayerGuideDBHelper.StBenedictOfNursiaTittle();
                        String stbenedictofnursia = prayerGuideDBHelper.StBenedictOfNursia();
                        Intent intent4 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stbenedictofnursiatittle, stbenedictofnursia);
                        startActivity(intent4);
                        break;
                    case 5:
                        String stbonaventuretittle = prayerGuideDBHelper.StBonaventureTittle();
                        String stbonaventure = prayerGuideDBHelper.StBonaventure();
                        Intent intent5 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stbonaventuretittle, stbonaventure);
                        startActivity(intent5);
                        break;
                    case 6:
                        String stceciliatittle = prayerGuideDBHelper.StCeciliaTittle();
                        String stcecilia = prayerGuideDBHelper.StCecilia();
                        Intent intent6 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stceciliatittle, stcecilia);
                        startActivity(intent6);
                        break;
                    case 7:
                        String stclareofassisitittle = prayerGuideDBHelper.StClareOfAssisiTittle();
                        String stclareofassisi = prayerGuideDBHelper.StClareOfAssisi();
                        Intent intent7 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stclareofassisitittle, stclareofassisi);
                        startActivity(intent7);
                        break;
                    case 8:
                        String stephremtittle = prayerGuideDBHelper.StEphremTittle();
                        String stephrem = prayerGuideDBHelper.StEphrem();
                        Intent intent8 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stephremtittle, stephrem);
                        startActivity(intent8);
                        break;
                    case 9:
                        String stfaustinasprayerbeforeeucharisttittle = prayerGuideDBHelper.StFaustinasPrayerBeforeEucharistTittle();
                        String stfaustinasprayerbeforeeucharist = prayerGuideDBHelper.StFaustinasPrayerBeforeEucharist();
                        Intent intent9 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stfaustinasprayerbeforeeucharisttittle, stfaustinasprayerbeforeeucharist);
                        startActivity(intent9);
                        break;
                    case 10:
                        String stfrancisofassisitittle = prayerGuideDBHelper.StFrancisOfAssisiTittle();
                        String stfrancisofassisi = prayerGuideDBHelper.StFrancisOfAssisi();
                        Intent intent10 = new Intent (Prayerofthesaint.this, Prayer.class);
                        Bundle b10 = new Bundle();
                        b10.putString("prayer", stfrancisofassisi);
                        b10.putString("prayer_title", stfrancisofassisitittle);
                        intent10.putExtras(b10);
                        startActivity(intent10);
                        break;
                    case 11:
                        String stignatuisprayeragainstdepressiontittle = prayerGuideDBHelper.StIgnatuisPrayerAgainstDepressionTittle();
                        String stignatuisprayeragainstdepression = prayerGuideDBHelper.StIgnatuisPrayerAgainstDepression();
                        Intent intent11 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stignatuisprayeragainstdepressiontittle, stignatuisprayeragainstdepression);
                        startActivity(intent11);
                        break;
                    case 12:
                        String stjosephtittle = prayerGuideDBHelper.StJosephTittle();
                        String stjoseph = prayerGuideDBHelper.StJoseph();
                        Intent intent12 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stjosephtittle, stjoseph);
                        startActivity(intent12);
                        break;
                    case 13:
                        String stmarymagdalenetittle = prayerGuideDBHelper.StMaryMagdaleneTittle();
                        String stmarymagdalene = prayerGuideDBHelper.StMaryMagdalene();
                        Intent intent13 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stmarymagdalenetittle, stmarymagdalene);
                        startActivity(intent13);
                        break;
                    case 14:
                        String stmichealthearchangel1tittle = prayerGuideDBHelper.StMichealTheArchangel1Tittle();
                        String stmichealthearchangel1 = prayerGuideDBHelper.StMichealTheArchangel1();
                        Intent intent14 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stmichealthearchangel1tittle, stmichealthearchangel1);
                        startActivity(intent14);
                        break;
                    case 15:
                        String stpioprayeroftrustandconfidencetittle = prayerGuideDBHelper.StPioPrayerOfTrustAndConfidenceTittle();
                        String stpioprayeroftrustandconfidence = prayerGuideDBHelper.StPioPrayerOfTrustAndConfidence();
                        Intent intent15 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stpioprayeroftrustandconfidencetittle, stpioprayeroftrustandconfidence);
                        startActivity(intent15);
                        break;
                    case 16:
                        String stteresaofavilaprayertittle = prayerGuideDBHelper.StTeresaOfAvilaPrayerTittle();
                        String stteresaofavilaprayer = prayerGuideDBHelper.StTeresaOfAvilaPrayer();
                        Intent intent16 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stteresaofavilaprayertittle, stteresaofavilaprayer);
                        startActivity(intent16);
                        break;
                    case 17:
                        String stthereseoflisieuxtittle = prayerGuideDBHelper.StThereseOfLisieuxTittle();
                        String stthereseoflisieux = prayerGuideDBHelper.StThereseOfLisieux();
                        Intent intent17 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stthereseoflisieuxtittle, stthereseoflisieux);
                        startActivity(intent17);
                        break;
                    case 18:
                        String stthomasaquinastittle = prayerGuideDBHelper.StThomasAquinasTittle();
                        String stthomasaquinas = prayerGuideDBHelper.StThomasAquinas();
                        Intent intent18 = new Intent (Prayerofthesaint.this, Prayer.class);
                        pref.savePrayer(stthomasaquinastittle, stthomasaquinas);
                        startActivity(intent18);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prayerofthesaint, menu);
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
            Intent aboutintent = new Intent(Prayerofthesaint.this, About.class);
            startActivity (aboutintent);
        }

        return super.onOptionsItemSelected(item);
    }

}
