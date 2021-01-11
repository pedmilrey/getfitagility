package com.agility.getfit.getfitagility.ui.modeselection

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.agility.getfit.getfitagility.R
import com.agility.getfit.getfitagility.databinding.ActivityModeSelectionBinding
import com.agility.getfit.getfitagility.models.ExerciseMode
import com.agility.getfit.getfitagility.ui.selectionlevelmenu.SelectionLevelActivity

class ModeSelectionActivity : AppCompatActivity(), ModeSelectionView {

    private lateinit var presenter: ModeSelectionPresenter
    lateinit var binding: ActivityModeSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_selection)
        initPresenter()
        initView()
    }

    private fun initPresenter() {
        presenter = ModeSelectionPresenter(this)
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mode_selection)

        binding.buttonAuto.setOnClickListener { presenter.onAutoButtonClicked() }

        binding.buttonManual.setOnClickListener { presenter.onManualButtonClicked() }
    }

    override fun goToManualModeScreen() {
        startActivity(SelectionLevelActivity.getIntent(this, ExerciseMode.MANUAL))
    }

    override fun goToAutoModeScreen() {
        startActivity(SelectionLevelActivity.getIntent(this, ExerciseMode.AUTO))
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, ModeSelectionActivity::class.java)
    }
}
