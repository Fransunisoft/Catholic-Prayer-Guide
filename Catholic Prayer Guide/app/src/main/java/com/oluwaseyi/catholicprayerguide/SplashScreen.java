package com.oluwaseyi.catholicprayerguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by francis on 31/05/2015.
 */

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(4000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i = new Intent(SplashScreen.this, com.oluwaseyi.catholicprayerguide.MainActivity.class);
                    finish();
                    startActivity(i);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        //TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}