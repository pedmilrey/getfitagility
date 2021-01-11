package com.agility.getfit.getfitagility.ui.tapautomatic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.agility.getfit.getfitagility.R;
import com.agility.getfit.getfitagility.databinding.ActivityTapAutomaticBinding;
import com.agility.getfit.getfitagility.models.ExerciseLevel;

import java.util.Timer;
import java.util.TimerTask;

public class TapAutomaticActivity extends AppCompatActivity implements TapAutomaticView {

    public static final String LEVEL_BUNDLE = "level_bundle";
    public static final String SECONDS_BUNDLE = "seconds_bundle";

    private ActivityTapAutomaticBinding binding;
    private TapAutomaticPresenter presenter;
    private Timer timer;
    private MediaPlayer mediaPlayer;

    public static Intent getIntent(Context context, ExerciseLevel mode, int seconds) {
        Intent intent = new Intent(context, TapAutomaticActivity.class);
        intent.putExtra(LEVEL_BUNDLE, mode.ordinal());
        intent.putExtra(SECONDS_BUNDLE, seconds);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        initView();
    }

    private void initPresenter() {
        presenter = new TapAutomaticPresenter(this);
        presenter.start(getIntent());
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tap_automatic);

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClicked();
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackPressed();
            }
        });
    }

    @Override
    public void startListeners(int secondsGap) {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHandler.obtainMessage(1).sendToTarget();

            }
        }, 0, secondsGap * 1000);

        binding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRestartClicked();
            }
        });

    }

    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            presenter.onTimerInterval();
        }
    };

    @Override
    public void removeListeners() {
        timer.cancel();
        timer.purge();
        binding.restart.setOnClickListener(null);
    }

    @Override
    public void showRestartButton() {
        binding.restart.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRestartButton() {
        binding.restart.setVisibility(View.GONE);

    }

    @Override
    public void showNextText() {
        binding.next.setVisibility(View.VISIBLE);

        binding.next.animate().alphaBy(0).alpha(1).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                binding.next.setVisibility(View.GONE);
            }
        }).start();
    }

    @Override
    public void showCounter() {
        binding.counter.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideCounter() {
        binding.counter.setVisibility(View.GONE);
    }

    @Override
    public void playSound() {
        if (mediaPlayer != null) {
            stopSound();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tonebeep);
        mediaPlayer.start();
    }

    @Override
    public void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void updateCounter(int counter) {
        binding.counter.setText(String.valueOf(counter));
    }

    @Override
    public void showStartButton() {
        binding.startButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideStartButton() {
        binding.startButton.setVisibility(View.GONE);
    }

    @Override
    public void setBackgroundColor(int colorResource) {
        binding.color.setBackgroundColor(ContextCompat.getColor(this, colorResource));
    }

    @Override
    public void setNumberColor(int colorResource) {
        binding.number.setTextColor(ContextCompat.getColor(this, colorResource));
    }

    @Override
    public void showNumber() {
        binding.number.setVisibility(View.VISIBLE);
    }

    @Override
    public void setNumber(int number) {
        binding.number.setText(String.valueOf(number));
    }

    @Override
    public void hideNumber() {
        binding.number.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();

    }

    @Override
    public void goBack() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mHandler != null) {
            mHandler = null;
        }
        if ((timer != null)) {
            timer.cancel();
            timer = null;
        }
    }
}
