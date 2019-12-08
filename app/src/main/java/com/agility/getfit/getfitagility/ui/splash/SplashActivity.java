package com.agility.getfit.getfitagility.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.agility.getfit.getfitagility.R;
import com.agility.getfit.getfitagility.ui.modeselection.ModeSelectionActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY = 1000;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToSelectionScreen();
            }
        }, DELAY);
    }

    private void goToSelectionScreen() {
        startActivity(ModeSelectionActivity.Companion.getIntent(this));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }
}
