package org.rbk.androidworkshop;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000; // 3 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Runnable runnable =  new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, RegisterUser.class);
                startActivity(i);

                finish();
            }
        };
        new Handler().postDelayed(runnable , SPLASH_TIME_OUT);
    }
}
