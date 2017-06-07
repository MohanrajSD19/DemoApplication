package com.idletimetracker;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;

/**
 * Created by Mohanraj.S,innobot-linux-4 on 7/6/17.
 */

public class MyApplication extends Application {
    private int lastInteractionTime;
    private Boolean isScreenOff = false;
    private static Context context;
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
        // ......
        //startUserInactivityDetectThread(); // start the thread to detect inactivity
        new ScreenReceiver();  // creating receive SCREEN_OFF and SCREEN_ON broadcast msgs from the device.
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

    /*public void  startUserInactivityDetectThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(15000); // checks every 15sec for inactivity
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    *//*if(isScreenOff || getLastInteractionTime()> 120000 ||  !isInForeGrnd)
                    {
                        //...... means USER has been INACTIVE over a period of
                        // and you do your stuff like log the user out
                    }*//*
                    if(isScreenOff || getLastInteractionTime()> 120000)
                    {

                        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);

                        boolean isScreenOn = pm.isScreenOn();
                        Log.e("screen on=", "" + isScreenOn);

                        if (isScreenOn == false) {

                            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "MyLock");

                            wl.acquire(10000);
                            PowerManager.WakeLock wl_cpu = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyCpuLock");

                            wl_cpu.acquire(10000);
                    }
                }
            }
        }).start();
    }
    }*/

    public long getLastInteractionTime() {
        return lastInteractionTime;
    }



    public long setLastInteractionTime(int lastInteractionTime) {
       return this.lastInteractionTime = lastInteractionTime;
    }

    private class ScreenReceiver extends BroadcastReceiver {

        protected ScreenReceiver() {
            // register receiver that handles screen on and screen off logic
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            registerReceiver(this, filter);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                isScreenOff = true;
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                isScreenOff = false;
            }
        }
    }
}