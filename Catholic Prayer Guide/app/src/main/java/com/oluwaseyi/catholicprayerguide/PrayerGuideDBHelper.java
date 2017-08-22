package com.oluwaseyi.catholicprayerguide;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrayerGuideDBHelper extends SQLiteOpenHelper {
    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.oluwaseyi.catholicprayerguide/databases/";

    private static final int DATABASE_VERSION = 1;

    public static String DB_NAME = "PrayerGuide";
    public static String TABLE_BASIC = "BasicPrayer";
    public static String TABLE_JESUS = "Prayertojesus";
    public static String TABLE_MARIAN = "MarianPrayers";
    public static String TABLE_SAINT = "Prayerofthesaints";
    public static String TABLE_OTHER = "Otherprayer";

    private SQLiteDatabase myDataBase;


    private final Context myContext;

    /**
     * * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application
     * assets and resources.
     *
     * @param context
     */

    public PrayerGuideDBHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }
    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application. * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //database dont exist yet
            e.printStackTrace();
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the * system folder, from where it can be accessed and handled. * This is done by transfering bytestream. *
     */
    private void CopyFiles() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private void deleteDataBase() {
        (new File((new StringBuilder(String.valueOf(DB_PATH))).append("PrayerGuide").toString())).delete();
    }

    //open database
    public boolean open() {

        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        return true;

    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws IOException {


        boolean dbExist = checkDataBase();
        if (dbExist) {
            //do nothing - database already exist
        } else {
            this.getWritableDatabase();
            try {
                CopyFiles();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    public String AngelusPrayers() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String angelus = null;
        if (cursor.moveToNext()) {
            angelus = cursor.getString(2);

        }
        cursor.close();
        myDataBase.close();
        return angelus;
    }

    public String AngelusPrayersTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String angelustittle = null;
        if (cursor.moveToNext()) {
            angelustittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return angelustittle;
    }
    public String ApostlesCreed() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String apostlescreed = null;

        if (cursor.moveToNext()) {
            apostlescreed = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return apostlescreed;
    }
    public String ApostlesCreedTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String apostlescreedtittle = null;
        if (cursor.moveToNext()) {
            apostlescreedtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return apostlescreedtittle;
    }
    public String Glorybe() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String glorybe = null;
        if (cursor.moveToNext()) {
            glorybe = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return glorybe;
    }
    public String GlorybeTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String glorybetittle = null;
        if (cursor.moveToNext()) {
            glorybetittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return glorybetittle;
    }
    public String GuardianAngel() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String guardianangel = null;
        if (cursor.moveToNext()) {
            guardianangel = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return guardianangel;
    }
    public String GuardianAngelTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String guardianangeltittle = null;
        if (cursor.moveToNext()) {
            guardianangeltittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return guardianangeltittle;
    }

    public String HailMary() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String hailmary = null;
        if (cursor.moveToNext()) {
            hailmary = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return hailmary;
    }
    public String HailMaryTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String hailmarytittle = null;
        if (cursor.moveToNext()) {
            hailmarytittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return hailmarytittle;
    }

    public String HolyRosary() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String holyrosary = null;
        if (cursor.moveToNext()) {
            holyrosary = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return holyrosary;
    }
    public String HolyRosaryTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String holyrosarytittle = null;
        if (cursor.moveToNext()) {
            holyrosarytittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return holyrosarytittle;
    }
    public String OurFather() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String ourfather = null;
        if (cursor.moveToNext()) {
            ourfather = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return ourfather;
    }
    public String OurFatherTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String ourfathertittle = null;
        if (cursor.moveToNext()) {
            ourfathertittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return ourfathertittle;
    }
    public String StMichealTheArchangel() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stmichealthearchangel = null;
        if (cursor.moveToNext()){
            stmichealthearchangel = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return stmichealthearchangel;
    }
    public String StMichealTheArchangelTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_BASIC + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stmichealthearchangeltittle = null;
        if (cursor.moveToNext()){
            stmichealthearchangeltittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return stmichealthearchangeltittle;
    }
    public String ActOfSpiritualCommunion() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String actofspiritualcommunion = null;
        if (cursor.moveToNext()) {
            actofspiritualcommunion = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return actofspiritualcommunion;
    }
    public String ActOfSpiritualCommunionTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String actofspiritualcommuniontittle = null;
        if (cursor.moveToNext()) {
            actofspiritualcommuniontittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return actofspiritualcommuniontittle;
    }

    public String AnimaChristi() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String animachristi = null;
        if (cursor.moveToNext()) {
            animachristi = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return animachristi;
    }
    public String AnimaChristiTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String animachristitittle = null;
        if (cursor.moveToNext()) {
            animachristitittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return animachristitittle;
    }

    public String ChristCandleOfHopePrayer() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String christcandleofhopeprayer = null;
        if (cursor.moveToNext()) {
            christcandleofhopeprayer = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return christcandleofhopeprayer;
    }
    public String ChristCandleOfHopePrayerTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String christcandleofhopeprayertittle = null;
        if (cursor.moveToNext()) {
            christcandleofhopeprayertittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return christcandleofhopeprayertittle;
    }
    public String HolyFace() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String holyface = null;
        if (cursor.moveToNext()) {
            holyface = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return holyface;
    }
    public String HolyFaceTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String holyfacetittle = null;
        if (cursor.moveToNext()) {
            holyfacetittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return holyfacetittle;
    }

    public String NovenaToTheDivineChildJesus() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String novenatothedivinechildjesus = null;
        if (cursor.moveToNext()) {
            novenatothedivinechildjesus = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return novenatothedivinechildjesus;
    }
    public String NovenaToTheDivineChildJesusTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String novenatothedivinechildjesustittle = null;
        if (cursor.moveToNext()) {
            novenatothedivinechildjesustittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return novenatothedivinechildjesustittle;
    }

    public String SacredHeart() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String sacredheart = null;
        if (cursor.moveToNext()) {
            sacredheart = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return sacredheart;
    }
    public String SacredHeartTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String sacredhearttittle = null;
        if (cursor.moveToNext()) {
            sacredhearttittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return sacredhearttittle;
    }
    public String ThanksgivingToTheTrinity() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String thanksgivingtothetrinity = null;
        if (cursor.moveToNext()) {
            thanksgivingtothetrinity = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return thanksgivingtothetrinity;
    }
    public String ThanksgivingToTheTrinityTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_JESUS + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String thanksgivingtothetrinitytittle = null;
        if (cursor.moveToNext()) {
            thanksgivingtothetrinitytittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return thanksgivingtothetrinitytittle;
    }
    public String ChildrensPrayerToMary() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String childrensprayertomary = null;
        if (cursor.moveToNext()) {
            childrensprayertomary = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return childrensprayertomary;
    }
    public String ChildrensPrayerToMaryTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String childrensprayertomarytittle = null;
        if (cursor.moveToNext()) {
            childrensprayertomarytittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return childrensprayertomarytittle;
    }

    public String DonBoscosPrayerToMary() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String donboscosprayertomary = null;
        if (cursor.moveToNext()) {
            donboscosprayertomary = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return donboscosprayertomary;
    }
    public String DonBoscosPrayerToMaryTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String donboscosprayertomarytittle = null;
        if (cursor.moveToNext()) {
            donboscosprayertomarytittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return donboscosprayertomarytittle;
    }
    public String ElectionPrayerToMary() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String electionprayertomary = null;
        if (cursor.moveToNext()) {
            electionprayertomary = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return electionprayertomary;
    }
    public String ElectionPrayerToMaryTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String electionprayertomarytittle = null;
        if (cursor.moveToNext()) {
            electionprayertomarytittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return electionprayertomarytittle;
    }
    public String InHonorOfTheImmaculateConception() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String inhonoroftheimmaculateconception = null;
        if (cursor.moveToNext()) {
            inhonoroftheimmaculateconception = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return inhonoroftheimmaculateconception;
    }
    public String InHonorOfTheImmaculateConceptionTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String inhonoroftheimmaculateconceptiontittle = null;
        if (cursor.moveToNext()) {
            inhonoroftheimmaculateconceptiontittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return inhonoroftheimmaculateconceptiontittle;
    }
    public String Magnificant() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String magnificant = null;
        if (cursor.moveToNext()) {
            magnificant = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return magnificant;
    }
    public String MagnificantTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String magnificanttittle = null;
        if (cursor.moveToNext()) {
            magnificanttittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return magnificanttittle;
    }

    public String Memorrare() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String memorrare = null;
        if (cursor.moveToNext()) {
            memorrare = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return memorrare;
    }
    public String MemorrareTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String memorraretittle = null;
        if (cursor.moveToNext()) {
            memorraretittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return memorraretittle;
    }

    public String OurLadyOfPerpetualHelp() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String ourladyofperpetualhelp = null;
        if (cursor.moveToNext()) {
            ourladyofperpetualhelp = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return ourladyofperpetualhelp;
    }
    public String OurLadyOfPerpetualHelpTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String ourladyofperpetualhelptittle = null;
        if (cursor.moveToNext()) {
            ourladyofperpetualhelptittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return ourladyofperpetualhelptittle;
    }
    public String PopesImmaculateConceptionPrayer() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String popesimmaculateconceptionprayer = null;
        if (cursor.moveToNext()) {
            popesimmaculateconceptionprayer = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return popesimmaculateconceptionprayer;
    }
    public String PopesImmaculateConceptionPrayerTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String popesimmaculateconceptionprayertittle = null;
        if (cursor.moveToNext()) {
            popesimmaculateconceptionprayertittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return popesimmaculateconceptionprayertittle;
    }
    public String PrayerToOurLadyOfLourdes() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 9 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayertoourladyoflourdes = null;
        if (cursor.moveToNext()) {
            prayertoourladyoflourdes = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayertoourladyoflourdes;
    }
    public String PrayerToOurLadyOfLourdesTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 9 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayertoourladyoflourdestittle = null;
        if (cursor.moveToNext()) {
            prayertoourladyoflourdestittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayertoourladyoflourdestittle;
    }

    public String ReginaCoeli() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 10 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String reginacoeli = null;
        if (cursor.moveToNext()) {
            reginacoeli = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return reginacoeli;
    }
    public String ReginaCoeliTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_MARIAN + " WHERE " + "_id" + "=" + " 10 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String reginacoelitittle = null;
        if (cursor.moveToNext()) {
            reginacoelitittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return reginacoelitittle;
    }
    public String DevotionToStJoseph() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String devotiontostjoseph = null;
        if (cursor.moveToNext()) {
            devotiontostjoseph = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return devotiontostjoseph;
    }
    public String DevotionToStJosephTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT;

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String devotiontostjosephtittle = null;

        if (cursor.moveToNext()) {
            devotiontostjosephtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return devotiontostjosephtittle;
    }

    public String LoricaOfStPatrick() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String loricaofstpatrick = null;
        if (cursor.moveToNext()) {
            loricaofstpatrick = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return loricaofstpatrick;
    }
    public String LoricaOfStPatrickTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String loricaofstpatricktittle = null;
        if (cursor.moveToNext()) {
            loricaofstpatricktittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return loricaofstpatricktittle;
    }
    public String MemorareOfStJoseph() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String memorareofstjoseph = null;
        if (cursor.moveToNext()) {
            memorareofstjoseph = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return memorareofstjoseph;
    }
    public String MemorareOfStJosephTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String memorareofstjosephtittle = null;
        if (cursor.moveToNext()) {
            memorareofstjosephtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return memorareofstjosephtittle;
    }

    public String StAugustineOfHippo() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String staugustineofhippo = null;
        if (cursor.moveToNext()) {
            staugustineofhippo = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return staugustineofhippo;
    }
    public String StAugustineOfHippoTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String staugustineofhippotittle = null;
        if (cursor.moveToNext()) {
            staugustineofhippotittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return staugustineofhippotittle;
    }
    public String StBenedictOfNursia() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stbenedictofnursia = null;
        if (cursor.moveToNext()) {
            stbenedictofnursia = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stbenedictofnursia;
    }
    public String StBenedictOfNursiaTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stbenedictofnursiatittle = null;
        if (cursor.moveToNext()) {
            stbenedictofnursiatittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stbenedictofnursiatittle;
    }
    public String StBonaventure() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stbonaventure = null;
        if (cursor.moveToNext()) {
            stbonaventure = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stbonaventure;
    }
    public String StBonaventureTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stbonaventuretittle = null;
        if (cursor.moveToNext()) {
            stbonaventuretittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stbonaventuretittle;
    }

    public String StCecilia() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stcecilia = null;
        if (cursor.moveToNext()) {
            stcecilia = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stcecilia;
    }
    public String StCeciliaTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stceciliatittle = null;
        if (cursor.moveToNext()) {
            stceciliatittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stceciliatittle;
    }
    public String StClareOfAssisi() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stclareofassisi = null;
        if (cursor.moveToNext()) {
            stclareofassisi = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stclareofassisi;
    }
    public String StClareOfAssisiTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stclareofassisitittle = null;
        if (cursor.moveToNext()) {
            stclareofassisitittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stclareofassisitittle;
    }
    public String StEphrem() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 9 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stephrem = null;
        if (cursor.moveToNext()) {
            stephrem = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stephrem;
    }
    public String StEphremTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 9 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stephremtittle = null;
        if (cursor.moveToNext()) {
            stephremtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stephremtittle;
    }

    public String StFaustinasPrayerBeforeEucharist() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 10 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stfaustinasprayerbeforeeucharist = null;
        if (cursor.moveToNext()) {
            stfaustinasprayerbeforeeucharist = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stfaustinasprayerbeforeeucharist;
    }
    public String StFaustinasPrayerBeforeEucharistTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 10 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stfaustinasprayerbeforeeucharisttittle = null;
        if (cursor.moveToNext()) {
            stfaustinasprayerbeforeeucharisttittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stfaustinasprayerbeforeeucharisttittle;
    }
    public String StFrancisOfAssisi() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 11 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stfrancisofassisi = null;
        if (cursor.moveToNext()) {
            stfrancisofassisi = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stfrancisofassisi;
    }
    public String StFrancisOfAssisiTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 11 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stfrancisofassisitittle = null;
        if (cursor.moveToNext()) {
            stfrancisofassisitittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stfrancisofassisitittle;
    }

    public String StIgnatuisPrayerAgainstDepression() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 12 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stignatuisprayeragainstdepression = null;
        if (cursor.moveToNext()) {
            stignatuisprayeragainstdepression = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stignatuisprayeragainstdepression;
    }
    public String StIgnatuisPrayerAgainstDepressionTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 12 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stignatuisprayeragainstdepressiontittle = null;
        if (cursor.moveToNext()) {
            stignatuisprayeragainstdepressiontittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stignatuisprayeragainstdepressiontittle;
    }
    public String StJoseph() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 13 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stjoseph = null;
        if (cursor.moveToNext()) {
            stjoseph = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stjoseph;
    }
    public String StJosephTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 13 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stjosephtittle = null;
        if (cursor.moveToNext()) {
            stjosephtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stjosephtittle;
    }

    public String StMaryMagdalene() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 14 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stmarymagdalene = null;
        if (cursor.moveToNext()) {
            stmarymagdalene = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stmarymagdalene;
    }
    public String StMaryMagdaleneTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 14 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stmarymagdalenetittle = null;
        if (cursor.moveToNext()) {
            stmarymagdalenetittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stmarymagdalenetittle;
    }

    public String StMichealTheArchangel1() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 15 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stmichealthearchangel1 = null;
        if (cursor.moveToNext()) {
            stmichealthearchangel1 = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stmichealthearchangel1;
    }
    public String StMichealTheArchangel1Tittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 15 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stmichealthearchangel1tittle = null;
        if (cursor.moveToNext()) {
            stmichealthearchangel1tittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stmichealthearchangel1tittle;
    }

    public String StPioPrayerOfTrustAndConfidence() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 16 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stpioprayeroftrustandconfidence = null;
        if (cursor.moveToNext()) {
            stpioprayeroftrustandconfidence = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stpioprayeroftrustandconfidence;
    }
    public String StPioPrayerOfTrustAndConfidenceTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 16 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stpioprayeroftrustandconfidencetittle = null;
        if (cursor.moveToNext()) {
            stpioprayeroftrustandconfidencetittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stpioprayeroftrustandconfidencetittle;
    }

    public String StTeresaOfAvilaPrayer() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 17 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stteresaofavilaprayer = null;
        if (cursor.moveToNext()) {
            stteresaofavilaprayer = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stteresaofavilaprayer;
    }
    public String StTeresaOfAvilaPrayerTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 17 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stteresaofavilaprayertittle = null;
        if (cursor.moveToNext()) {
            stteresaofavilaprayertittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stteresaofavilaprayertittle;
    }
    public String StThereseOfLisieux() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 18 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stthereseoflisieux = null;
        if (cursor.moveToNext()) {
            stthereseoflisieux = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stthereseoflisieux;
    }
    public String StThereseOfLisieuxTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 18 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stthereseoflisieuxtittle = null;
        if (cursor.moveToNext()) {
            stthereseoflisieuxtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stthereseoflisieuxtittle;
    }

    public String StThomasAquinas() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 19 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stthomasaquinas = null;
        if (cursor.moveToNext()) {
            stthomasaquinas = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return stthomasaquinas;
    }
    public String StThomasAquinasTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_SAINT + " WHERE " + "_id" + "=" + " 19 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String stthomasaquinastittle = null;
        if (cursor.moveToNext()) {
            stthomasaquinastittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return stthomasaquinastittle;
    }

    public String ChristmasAnticipationPrayer() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String christmasanticipationprayer = null;
        if (cursor.moveToNext()) {
            christmasanticipationprayer = cursor.getString(2);
        }
        cursor.close();
        myDataBase.close();
        return christmasanticipationprayer;
    }
    public String ChristmasAnticipationPrayerTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String christmasanticipationprayertittle = null;
        if (cursor.moveToNext()) {
            christmasanticipationprayertittle = cursor.getString(1);
        }
        cursor.close();
        myDataBase.close();
        return christmasanticipationprayertittle;
    }

    public String EpiscopalBlessing() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String episcopalblessing = null;
        if (cursor.moveToNext()) {
            episcopalblessing = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return episcopalblessing;
    }
    public String EpiscopalBlessingTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 2 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String episcopalblessingtittle = null;
        if (cursor.moveToNext()) {
            episcopalblessingtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return episcopalblessingtittle;
    }
    public String IntercessionOfPopeJohnPaulII() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String intercessionofpopejohnpaulII = null;
        if (cursor.moveToNext()) {
            intercessionofpopejohnpaulII = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return intercessionofpopejohnpaulII;
    }
    public String IntercessionOfPopeJohnPaulIITittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 3 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String intercessionofpopejohnpaulIItittle = null;
        if (cursor.moveToNext()) {
            intercessionofpopejohnpaulIItittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return intercessionofpopejohnpaulIItittle;
    }

    public String MiscarriagePrayer() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String miscarriageprayer = null;
        if (cursor.moveToNext()) {
            miscarriageprayer = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return miscarriageprayer;
    }
    public String MiscarriagePrayerTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 4 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String miscarriageprayertittle = null;
        if (cursor.moveToNext()) {
            miscarriageprayertittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return miscarriageprayertittle;
    }

    public String MorningOffering() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String morningoffering = null;
        if (cursor.moveToNext()) {
            morningoffering = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return morningoffering;
    }
    public String MorningOfferingTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 5 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String morningofferingtittle = null;
        if (cursor.moveToNext()) {
            morningofferingtittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return morningofferingtittle;
    }

    public String PrayerAfterMass() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayeraftermass = null;
        if (cursor.moveToNext()) {
            prayeraftermass = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayeraftermass;
    }
    public String PrayerAfterMassTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 6 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayeraftermasstittle = null;
        if (cursor.moveToNext()) {
            prayeraftermasstittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayeraftermasstittle;
    }

    public String PrayerBeforeMass() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerbeforemass = null;
        if (cursor.moveToNext()) {
            prayerbeforemass = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerbeforemass;
    }
    public String PrayerBeforeMassTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 7 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerbeforemasstittle = null;
        if (cursor.moveToNext()) {
            prayerbeforemasstittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerbeforemasstittle;
    }

    public String PrayerForEmployment() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerformployment = null;
        if (cursor.moveToNext()) {
            prayerformployment = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerformployment;
    }
    public String PrayerForEmploymentTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 8 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerformploymenttittle = null;
        if (cursor.moveToNext()) {
            prayerformploymenttittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerformploymenttittle;
    }

    public String PrayerForOurPresidentAndPublicOfficials() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 9 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforourpresidentandpublicofficials = null;
        if (cursor.moveToNext()) {
            prayerforourpresidentandpublicofficials = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerforourpresidentandpublicofficials;
    }
    public String PrayerForOurPresidentAndPublicOfficialsTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 9 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforourpresidentandpublicofficialstittle = null;
        if (cursor.moveToNext()) {
            prayerforourpresidentandpublicofficialstittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerforourpresidentandpublicofficialstittle;
    }

    public String PrayerForHelpAgainstSpiritualEnemies() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 10 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforhelpagainstspiritualenemies = null;
        if (cursor.moveToNext()) {
            prayerforhelpagainstspiritualenemies = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerforhelpagainstspiritualenemies;
    }
    public String PrayerForHelpAgainstSpiritualEnemiesTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 10 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforhelpagainstspiritualenemiestittle = null;
        if (cursor.moveToNext()) {
            prayerforhelpagainstspiritualenemiestittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerforhelpagainstspiritualenemiestittle;
    }

    public String PrayerForLife() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 11 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforlife = null;
        if (cursor.moveToNext()) {
            prayerforlife = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerforlife;
    }
    public String PrayerForLifeTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 11 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforlifetittle = null;
        if (cursor.moveToNext()) {
            prayerforlifetittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerforlifetittle;
    }

    public String PrayerForLifeThroughoutTheYear() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 12 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforlifethroughouttheyear = null;
        if (cursor.moveToNext()) {
            prayerforlifethroughouttheyear = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerforlifethroughouttheyear;
    }
    public String PrayerForLifeThroughoutTheYearTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 12 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforlifethroughouttheyeartittle = null;
        if (cursor.moveToNext()) {
            prayerforlifethroughouttheyeartittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerforlifethroughouttheyeartittle;
    }

    public String PrayerForTheUnborn() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 13 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerfortheunborn = null;
        if (cursor.moveToNext()) {
            prayerfortheunborn = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerfortheunborn;
    }
    public String PrayerForTheUnbornTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 13 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerfortheunborntittle = null;
        if (cursor.moveToNext()) {
            prayerfortheunborntittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerfortheunborntittle;
    }

    public String PrayerForTravelers() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 14 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerfortravelers = null;
        if (cursor.moveToNext()) {
            prayerfortravelers = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerfortravelers;
    }
    public String PrayerForTravelersTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 14 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerfortravelerstittle = null;
        if (cursor.moveToNext()) {
            prayerfortravelerstittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerfortravelerstittle;
    }

    public String PrayerForVocations() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 15 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforvocations = null;
        if (cursor.moveToNext()) {
            prayerforvocations = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return prayerforvocations;
    }
    public String PrayerForVocationsTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 15 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String prayerforvocationstittle = null;
        if (cursor.moveToNext()) {
            prayerforvocationstittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return prayerforvocationstittle;
    }

    public String ShortPrayer() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 16 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String shortprayer = null;
        if (cursor.moveToNext()) {
            shortprayer = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return shortprayer;
    }
    public String ShortPrayerTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 16 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String shortprayertittle = null;
        if (cursor.moveToNext()) {
            shortprayertittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return shortprayertittle;
    }

    public String ThanksgivingAfterMass() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 17 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String thanksgivingaftermass = null;
        if (cursor.moveToNext()) {
            thanksgivingaftermass = cursor.getString(2);
        }

        cursor.close();
        myDataBase.close();
        return thanksgivingaftermass;
    }
    public String ThanksgivingAfterMassTittle() {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myPath = DB_PATH + DB_NAME;
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_OTHER + " WHERE " + "_id" + "=" + " 17 ";

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = myDataBase.rawQuery(query, null);
        String thanksgivingaftermasstittle = null;
        if (cursor.moveToNext()) {
            thanksgivingaftermasstittle = cursor.getString(1);
        }

        cursor.close();
        myDataBase.close();
        return thanksgivingaftermasstittle;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing"return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.
}
