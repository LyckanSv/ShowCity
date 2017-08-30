package com.app.lyckan.showcity.help;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.app.lyckan.showcity.LoginActivity;
import com.app.lyckan.showcity.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class HelpActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("Bienvenido!", "Estas un paso más cerca de estar cerca de todo",
                R.drawable.ic_showcitylogo, Color.parseColor("#f64c73")));
        addSlide(AppIntroFragment.newInstance("Inicia sesion!", "Solo te falta un paso para ser especial, registrate y encuentra algo interesante",
                R.drawable.ic_showcitylogo, Color.parseColor("#20d2bb")));
        addSlide(AppIntroFragment.newInstance("Comparte!", "Comparte los articulos de interesantes para ti",
                R.drawable.ic_showcitylogo, Color.parseColor("#3395ff")));
        addSlide(AppIntroFragment.newInstance("Puntea", "Califica todo lo que veas, busca hasta debajo de las piedras!",
                R.drawable.ic_showcitylogo, Color.parseColor("#c873f4")));
        // setFadeAnimation();
        setDepthAnimation();
//        setFadeAnimation();
//        setZoomAnimation();
//        setFlowAnimation();
//        setSlideOverAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        Toast.makeText(this,"Leelo :)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        //Toast.makeText(this,"You Pressed Done!!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.

    }

}