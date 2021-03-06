package com.agility.getfit.getfitagility.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agility.getfit.getfitagility.R;
import com.agility.getfit.getfitagility.ui.selectionMenu.SelectionActivity;

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
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
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
