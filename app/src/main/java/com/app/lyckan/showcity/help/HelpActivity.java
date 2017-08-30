package com.app.lyckan.showcity.help;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.app.lyckan.showcity.LoginActivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import com.app.lyckan.showcity.R;
import com.github.paolorotolo.appintro.AppIntro;

public class HelpActivity extends AppIntro implements IntroFragment_1.OnFragmentInteractionListener,
        IntroFragment_2.OnFragmentInteractionListener,
        IntroFragment_3.OnFragmentInteractionListener,
        IntroFragment_4.OnFragmentInteractionListener{

    //private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //preferenceHelper = new PreferenceHelper(this);

//        if(preferenceHelper.getIntro().equals("no")){
//            Intent intent = new Intent(HelpActivity.this, LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            this.finish();
//        }

        addSlide(new IntroFragment_1());  //extend AppIntro and comment setContentView
        addSlide(new IntroFragment_2());
        addSlide(new IntroFragment_3());
        addSlide(new IntroFragment_4());


    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        Intent intent = new Intent(HelpActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        //preferenceHelper.putIntro("no");
        Intent intent = new Intent(HelpActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

    @Override  // this method is used for removing top and bottom navbars(fullscreen)
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
