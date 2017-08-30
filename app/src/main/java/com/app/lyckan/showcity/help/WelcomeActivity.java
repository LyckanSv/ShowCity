package com.app.lyckan.showcity.help;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.lyckan.showcity.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button btn;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn = (Button) findViewById(R.id.btn);
        preferenceHelper = new PreferenceHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceHelper.putIntro("");
                onBackPressed();
            }
        });

    }
}
