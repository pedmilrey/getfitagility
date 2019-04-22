package com.agility.getfit.getfitagility.ui.selectionMenu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.agility.getfit.getfitagility.R;
import com.agility.getfit.getfitagility.databinding.ActivitySelectionBinding;
import com.agility.getfit.getfitagility.ui.tap.TapActivity;

public class SelectionActivity extends AppCompatActivity implements SelectionView {

    private ActivitySelectionBinding binding;
    private SelectionPresenter presenter;

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
        presenter = new SelectionPresenter(this);
    }

    @Override
    public void goToExerciceScreen(@SelectionPresenter.ExerciseLevel int mode) {
        startActivity(TapActivity.getIntent(this, mode));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }
}
