package com.animation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mohanraj.S,innobot-linux-4 on 13/6/17.
 */

public class TimerAnimcation extends AppCompatActivity {
    ImageView img_animation = null;
    TextView txtVw_hello= null;
    ToggleButton myTogg= null;

    public static final int IDLE_DELAY_MINUTES = 3000; // 5 min = 5 * 60 * 1000 ms
    private Timer timer;
    private float mRandomFloat ,fromXDelta=0.0f,toXDelta=0.0f,fromYDelta=0.0f,toYDelta=0.0f;
    int START = 50;
    int END = 800;
    Random random;
    ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConfigviews();
    }

    private void setConfigviews(){
        img_animation = (ImageView) findViewById(R.id.img_animation);
        txtVw_hello = (TextView)findViewById(R.id.txtVw_hello);
        myTogg = (ToggleButton)findViewById(R.id.toggleButton);
    }


    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        setAnimationTimeDelay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*if (timer != null) {
            timer.cancel();
            Log.i("Main", "cancel timer onResume");
            timer = null;
        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*if (timer != null) {
            timer.cancel();
            Log.i("Main", "cancel timer onPause");
            timer = null;
        }*/
        //getUniqueRandomNumber();
        //setAnimationTimeDelay();
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            Log.i("Main", "cancel timer onDestroy");
            timer = null;
        }
    }*/

    private void setTranslateAnim( float fromXDelta,float toXDelta,float fromYDelta,float toYDelta) {
        //TranslateAnimation animation = new TranslateAnimation(100.0f, 500.0f,600.0F, 350.0f);
        TranslateAnimation animation = new TranslateAnimation(fromXDelta, toXDelta,fromYDelta, toYDelta);
        animation.setDuration(2500);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(2);
        animation.setZAdjustment(10);
        animation.setFillAfter(true);
        img_animation.startAnimation(animation);
    }
    private void getUniqueRandomNumber(){
        for (int i=50; i<800; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int jj=0;
        for ( jj=50; jj<54; jj++) {
            System.out.println("UniqueRandomNumber:"+list.get(jj));
            switch(jj){

                case 50:
                    fromXDelta =(float) list.get(jj);
                    break;
                case 51:
                    toXDelta=(float) list.get(jj);
                    break;
                case 52:
                    fromYDelta=(float) list.get(jj);
                    break;
                case 53:
                    toYDelta=(float) list.get(jj);
                    break;
            }
        }


    }

    private void setAnimationTimeDelay(){
        timer = new Timer();
        Log.i("Main", "Invoking Animation timer");
       HandAnimationTask mHandAnimationTask = new HandAnimationTask();
        timer.schedule(mHandAnimationTask, IDLE_DELAY_MINUTES); //auto logout in 5 minutes
    }

    private class HandAnimationTask extends TimerTask  {

        @Override
        public void run() {
            // getUniqueRandomNumber();
            System.out.println("Invoke Delay Timer ");
            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //view.startAnimation(animation);
                        if (fromXDelta != 0.0f && toXDelta != 0.0f && fromYDelta != 0.0f && toYDelta != 0.0f) {
                            setTranslateAnim(fromXDelta, toXDelta, fromYDelta, toYDelta);
                        }
                    }
                }, 1000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
