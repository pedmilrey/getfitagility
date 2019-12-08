package com.agility.getfit.getfitagility.ui.selectionlevelmenu;

import com.agility.getfit.getfitagility.models.ExerciseLevel;
import com.agility.getfit.getfitagility.models.ExerciseMode;

/**
 * Created by pedro.millan on 03/09/2017.
 */

public class SelectionLevelPresenter {

    private SelectionLevelView view;
    private ExerciseMode mode;

    SelectionLevelPresenter(SelectionLevelView view, ExerciseMode exerciseMode) {
        this.view = view;
        this.mode = exerciseMode;
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

    public void start() {
        if (mode == ExerciseMode.AUTO) {
            view.showSeekbar();
        }
    }
}
