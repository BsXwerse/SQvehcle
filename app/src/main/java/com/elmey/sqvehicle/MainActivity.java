package com.elmey.sqvehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.royrodriguez.transitionbutton.TransitionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TransitionButton transitionButton = findViewById(R.id.transition_button);
        transitionButton.setOnClickListener((View.OnClickListener) v -> {
            transitionButton.startAnimation();
            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                boolean isSuccessful = true;
                if (isSuccessful) {
                    transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                        @Override
                        public void onAnimationStopEnd() {
                            Intent intent = new Intent(getBaseContext(), TestActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });
                } else {
                    transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.SHAKE, null);
                }
            }, 1000);
        });
    }
}