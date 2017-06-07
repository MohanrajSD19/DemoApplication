package com.idletimetracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mohanraj.S,innobot-linux-4 on 7/6/17.
 */

public class IdealTimeActivity_POC_1 extends AppCompatActivity {
    private Timer timer;
    //public static final int IDLE_DELAY_MINUTES = 1; // 5 min = 5 * 60 * 1000 ms
    public static final int IDLE_DELAY_MINUTES = 30000; // 5 min = 5 * 60 * 1000 ms


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idealtiemer_poc_1);

    }

    @Override
    protected void onPause() {
        super.onPause();

        timer = new Timer();
        Log.i("Main", "Invoking logout timer");
        LogOutTimerTask logoutTimeTask = new LogOutTimerTask();
        timer.schedule(logoutTimeTask, IDLE_DELAY_MINUTES); //auto logout in 5 minutes
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timer != null) {
            timer.cancel();
            Log.i("Main", "cancel timer");
            timer = null;
        }
        LogoutTimeDelay();
    }


    private void LogoutTimeDelay(){
        timer = new Timer();
        Log.i("Main", "Invoking logout timer");
        LogOutTimerTask logoutTimeTask = new LogOutTimerTask();
        timer.schedule(logoutTimeTask, IDLE_DELAY_MINUTES); //auto logout in 5 minutes
    }
    private class LogOutTimerTask extends TimerTask {

        @Override
        public void run() {

            //redirect user to login screen
            Intent i = new Intent(IdealTimeActivity_POC_1.this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    Handler _idleHandler = new Handler();
    Runnable _idleRunnable = new Runnable() {
        @Override
        public void run() {
            //handle your IDLE state
        }
    };


}