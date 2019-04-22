package com.agility.getfit.getfitagility.ui.selectionMenu;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by pedro.millan on 03/09/2017.
 */

public class SelectionPresenter {
    
    private SelectionView view;

    public SelectionPresenter(SelectionView view) {
        this.view = view;
    }

    public void onButton1Clicked() {
        view.goToExerciceScreen(LEVEL_1);
    }

    public void onButton2Clicked() {
        view.goToExerciceScreen(LEVEL_2);
    }

    public void onButton3Clicked() {
        view.goToExerciceScreen(LEVEL_3);
    }

    @Retention(SOURCE)
    @IntDef({LEVEL_1, LEVEL_2, LEVEL_3})
    public @interface ExerciseLevel {}
    public static final int LEVEL_1 = 0;
    public static final int LEVEL_2 = 1;
    public static final int LEVEL_3 = 2;

}
