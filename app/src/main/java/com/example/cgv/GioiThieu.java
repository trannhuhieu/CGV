package com.example.cgv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GioiThieu extends AppCompatActivity {
    private static final int SPLASH_SCREEN_DURATION = 500; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioithieu);

        ImageView imageView = findViewById(R.id.imgthoithieu);
        Animation slideRightAnimation = new TranslateAnimation(100, 0, 0, 0);
        slideRightAnimation.setDuration(2000);
        slideRightAnimation.setFillAfter(true);
        imageView.startAnimation(slideRightAnimation);

        // Use a Handler to switch to the next screen after a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity
                Intent intent = new Intent(GioiThieu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }
}
