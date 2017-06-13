package com.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     ImageView img_animation = null;
     TextView txtVw_hello= null;
     ToggleButton myTogg= null;
    //public static final long DISCONNECT_TIMEOUT = 300000; // 5 min = 5 * 60 * 1000 ms

    public static final long DISCONNECT_TIMEOUT = 1000; // 5 min = 5 * 60 * 1000 ms
    private float mRandomFloat ,fromXDelta=0.0f,toXDelta=0.0f,fromYDelta=0.0f,toYDelta=0.0f;
    int START = 50;
    int END = 800;
    Random random;
    ArrayList<Integer> list = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new MyView(this));
        //setRandomDeltaValues();
        setConfigviews();
        getUniqueRandomNumber();
    }

    @Override
    public void onUserInteraction(){
        //resetDisconnectTimer();
    }

    @Override
    public void onResume() {
        super.onResume();
        //resetDisconnectTimer();
    }


    private void setConfigviews(){
        img_animation = (ImageView) findViewById(R.id.img_animation);
        txtVw_hello = (TextView)findViewById(R.id.txtVw_hello);
        myTogg = (ToggleButton)findViewById(R.id.toggleButton);
    }

    private void setTranslateAnim(){
        //TranslateAnimation animation = new TranslateAnimation(50.0f, 400.0f,00.0f, 350.0f);
        TranslateAnimation animation = new TranslateAnimation(720.0f, 500.0f,500.0F, 350.0f);
        animation.setDuration(2500);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(2);
        animation.setZAdjustment(10);
        animation.setFillAfter(true);
        img_animation.startAnimation(animation);
    }

   private void  setFadeInFadeOutAnim(){
        // Custom animation on image
        //ImageView myView = (ImageView)splashDialog.findViewById(R.id.splashscreenImage);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(img_animation, "alpha",  1f, .2f);
        fadeOut.setDuration(4000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(img_animation, "alpha", .2f, 1f);
        fadeIn.setDuration(1500);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();
    }

    private void setFadeInAnim(){
        txtVw_hello.animate().alpha(1).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
            @Override
            public void run() {
                img_animation.animate().alpha(0).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
            }
        }).start();
    }

    private Handler disconnectHandler = new Handler(){
        public void handleMessage(Message msg) {
        }
    };

    private Runnable disconnectCallback = new Runnable() {
        @Override
        public void run() {
            // Perform any required operation on disconnect
        }
    };

    public void resetDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT);
    }

    public void stopDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
    }

    public class MyView extends View {
        public MyView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);
            int x = getWidth();
            int y = getHeight();
            int radius;
            radius = 100;
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            // Use Color.parseColor to define HTML colors
            paint.setColor(Color.parseColor("#CD5C5C"));
            canvas.drawCircle(x / 2, y / 2, radius, paint);
        }
    }


    private  void showRandomInteger(int aStart, int aEnd, Random aRandom){
        if ( aStart > aEnd ) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * aRandom.nextDouble());
        System.out.println("Generated fraction : " + fraction);
        int randomNumber =  (int)(fraction + aStart);
        System.out.println("Generated : " + randomNumber);
        mRandomFloat=(float) randomNumber;
        if(fromXDelta!=mRandomFloat) {
            if (fromXDelta != 0.0f) {
                fromXDelta = mRandomFloat;
            } else if (toXDelta != 0.0f) {
                toXDelta = mRandomFloat;
            } else if (fromYDelta != 0.0f) {
                fromYDelta = mRandomFloat;
            } else if (toYDelta != 0.0f) {
                toYDelta = mRandomFloat;
            }
        }



    }

    private void getRandomLoop(){
        for (int idx = 50; idx <= 800; ++idx){
            showRandomInteger(START, END, random);
        }
    }

    private void setRandomDeltaValues(){
        random = new Random();
        if(fromXDelta==mRandomFloat){
            if(fromXDelta != 0.0f){
                getRandomLoop();
            }else
            if(toXDelta!= 0.0f){
                getRandomLoop();
            }else
            if(fromYDelta != 0.0f){
                getRandomLoop();
            }else
            if(toYDelta!= 0.0f){
                getRandomLoop();
            }else{
                setTranslateAnim( fromXDelta, toXDelta, fromYDelta, toYDelta);
            }

        }
    }

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

   /* public class UniqueRandomNumbers {

        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=1; i<11; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i=0; i<3; i++) {
                System.out.println(list.get(i));
            }
        }
    }*/

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
        if(fromXDelta!=0.0f && toXDelta!=0.0f  &&  fromYDelta!=0.0f  &&  toYDelta!=0.0f ) {
            setTranslateAnim(fromXDelta, toXDelta, fromYDelta, toYDelta);
        }

    }

}
