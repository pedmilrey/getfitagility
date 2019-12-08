package com.agility.getfit.getfitagility.ui.modeselection

class ModeSelectionPresenter(private val view: ModeSelectionView) {
    fun onAutoButtonClicked() {
        view.goToAutoModeScreen()
    }

    fun onManualButtonClicked() {
        view.goToManualModeScreen()
    }
}