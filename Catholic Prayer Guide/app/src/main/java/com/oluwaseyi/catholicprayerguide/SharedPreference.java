package com.oluwaseyi.catholicprayerguide;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import java.util.HashMap;

/**
 * Created by francis on 26/06/2015.
 */

public class SharedPreference {
    //shared preferences
    SharedPreferences myPref;
    //Editor for the shared preferences
    SharedPreferences.Editor editor;
    //Context
    Context _context;
    //shared pref mode
    int PRIVATE_MODE = 0;

    int scorre;
    //shared pref file name
    private static final String PREF_NAME = "PrayerPref";
    //title key
    public static final String KEY_TITLE = "title";
    //prayer key
    public static final String KEY_PRAYER = "prayer";

    public SharedPreference (Context context){
        this._context = context;
        myPref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = myPref.edit();
    }




    //creating login session
    public void savePrayer(String prayer_title, String prayer){
        //put prayer title and prayer
        editor.putString(KEY_TITLE, prayer_title);
        editor.putString(KEY_PRAYER, prayer);
        //commit the changes
        editor.commit();
    }



    //get stored session data
    public HashMap<String, String> getPrayerDetails(){
        HashMap<String, String> prayer = new HashMap<String, String>();
        prayer.put(KEY_TITLE, myPref.getString(KEY_TITLE, null));
        prayer.put(KEY_PRAYER, myPref.getString(KEY_PRAYER, null));
        return prayer;
    }




}
