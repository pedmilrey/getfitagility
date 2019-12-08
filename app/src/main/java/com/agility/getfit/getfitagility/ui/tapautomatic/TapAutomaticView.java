package com.agility.getfit.getfitagility.ui.tapautomatic;

public interface TapAutomaticView {
    void hideStartButton();

    void setBackgroundColor(int colorResource);

    void setNumberColor(int colorResource);

    void showNumber();

    void setNumber(int number);

    void hideNumber();

    void showStartButton();

    void startListeners(int secondsGap);

    void removeListeners();

    void showRestartButton();

    void hideRestartButton();

    void showNextText();

    void showCounter();

    void updateCounter(int counter);

    void hideCounter();
}
