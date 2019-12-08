package com.agility.getfit.getfitagility.ui.selectionlevelmenu;

import com.agility.getfit.getfitagility.models.ExerciseLevel;

/**
 * Created by pedro.millan on 03/09/2017.
 */

public class SelectionLevelPresenter {

    private SelectionLevelView view;

    SelectionLevelPresenter(SelectionLevelView view) {
        this.view = view;
    }

    void onButton1Clicked() {
        view.goToExerciseScreen(ExerciseLevel.LEVEL_1);
    }

    void onButton2Clicked() {
        view.goToExerciseScreen(ExerciseLevel.LEVEL_2);
    }

    void onButton3Clicked() {
        view.goToExerciseScreen(ExerciseLevel.LEVEL_3);
    }

}
