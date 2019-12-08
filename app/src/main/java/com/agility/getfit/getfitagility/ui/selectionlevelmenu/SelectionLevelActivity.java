package com.agility.getfit.getfitagility.ui.selectionlevelmenu;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.agility.getfit.getfitagility.R;
import com.agility.getfit.getfitagility.databinding.ActivitySelectionBinding;
import com.agility.getfit.getfitagility.models.ExerciseLevel;
import com.agility.getfit.getfitagility.models.ExerciseMode;
import com.agility.getfit.getfitagility.ui.tap.TapActivity;

public class SelectionLevelActivity extends AppCompatActivity implements SelectionLevelView {

    public static final String MODE_BUNDLE = "mode_bundle";


    private ActivitySelectionBinding binding;
    private SelectionLevelPresenter presenter;

    public static Intent getIntent(Context context, ExerciseMode mode) {
        Intent intent = new Intent(context, SelectionLevelActivity.class);
        intent.putExtra(MODE_BUNDLE, mode.ordinal());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        initView();

    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_selection);

        //Button 1
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButton1Clicked();
            }
        });

        //Button 2
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButton2Clicked();
            }
        });

        //Button 2
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButton3Clicked();
            }
        });
    }

    private void initPresenter() {
        presenter = new SelectionLevelPresenter(this);
    }


    @Override
    public void goToExerciseScreen(ExerciseLevel exerciseLevel) {
        startActivity(TapActivity.getIntent(this, exerciseLevel));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
