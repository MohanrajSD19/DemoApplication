package com.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
     ImageView img_animation = null;
     TextView txtVw_hello= null;
     ToggleButton myTogg= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConfigviews();
        setTranslateAnim();
        setFadeInFadeOutAnim();
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
}
