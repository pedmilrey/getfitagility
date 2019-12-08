package com.agility.getfit.getfitagility.ui.tap;

/**
 * Created by pedro.millan on 03/09/2017.
 */

public interface TapView {
    void hideStartButton();

    void setBackgroundColor(int colorResource);

    void setNumberColor(int colorResource);

    void showNumber();

    void setNumber(int number);

    void hideNumber();

    void showStartButton();

    void startListeners();

    void removeListeners();

    void showRestartButton();

    void hideRestartButton();

    void showNextText();

    void showCounter();

    void updateCounter(int counter);

    void hideCounter();

    void playSound();

    void stopSound();

    void goBack();

}
