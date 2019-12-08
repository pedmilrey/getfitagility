package com.agility.getfit.getfitagility.ui.tap;

import android.content.Intent;
import android.util.Pair;

import com.agility.getfit.getfitagility.R;
import com.agility.getfit.getfitagility.models.Disk;
import com.agility.getfit.getfitagility.models.ExerciseLevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.agility.getfit.getfitagility.ui.tap.TapActivity.LEVEL_BUNDLE;

/**
 * Created by pedro.millan on 03/09/2017.
 */

public class TapPresenter {

    private TapView view;
    private ExerciseLevel exerciseLevel;

    private Map<Integer, Disk> diskMap = new HashMap<>();
    private int counter = 0;

    public TapPresenter(TapView view) {
        this.view = view;
    }

    public void start(Intent intent) {
        initDiskMap();
        //noinspection ResourceType
        exerciseLevel = ExerciseLevel.values()[intent.getIntExtra(LEVEL_BUNDLE, 0)];
    }

    private void initDiskMap() {
        Disk disk1 = new Disk("orange", 1);
        Disk disk2 = new Disk("yellow", 2);
        Disk disk3 = new Disk("red", 3);
        Disk disk4 = new Disk("blue", 4);
        Disk disk5 = new Disk("green", 5);

        diskMap.put(1, disk1);
        diskMap.put(2, disk2);
        diskMap.put(3, disk3);
        diskMap.put(4, disk4);
        diskMap.put(5, disk5);
    }

    public void onScreenTap() {
        counter++;
        showNextScreen();

    }

    public void onRestartClicked() {
        counter = 0;
        view.hideCounter();
        view.setBackgroundColor(R.color.white);
        view.removeListeners();
        view.hideRestartButton();
        view.showStartButton();
        view.hideNumber();
        view.stopSound();
    }

    public void onStartButtonClicked() {
        counter = 0;
        view.showCounter();
        view.updateCounter(counter);
        view.hideStartButton();
        view.startListeners();
        view.showRestartButton();
        showNextScreen();
    }


    private Disk getRandomDisk() {
        Random random = new Random();
        List<Integer> keys = new ArrayList(diskMap.keySet());
        Integer randomDisk = keys.get(random.nextInt(keys.size()));
        return diskMap.get(randomDisk);
    }

    private Pair<Disk, Disk> getTwoRandomDisks() {
        List<Integer> keys = new ArrayList(diskMap.keySet());
        Collections.shuffle(keys);
        return new Pair<>(diskMap.get(keys.get(0)), diskMap.get(keys.get(1)));

    }

    private void showNextScreen() {
        Disk randomDisk;
        Disk complementaryDisk;
        view.showNextText();
        view.playSound();
        view.updateCounter(counter);
        switch (exerciseLevel) {
            case LEVEL_1:
                randomDisk = getRandomDisk();
                view.setBackgroundColor(R.color.white);
                view.showNumber();
                view.setNumberColor(R.color.black);
                view.setNumber(randomDisk.getNumber());
                break;
            case LEVEL_2:
                randomDisk = getRandomDisk();
                view.hideNumber();
                view.setBackgroundColor(getDiskColor(randomDisk));
                break;
            case LEVEL_3:
                Pair<Disk, Disk> pairDisk = getTwoRandomDisks();
                randomDisk = pairDisk.first;
                complementaryDisk = pairDisk.second;
                view.setBackgroundColor(R.color.colorAccent);
                view.showNumber();
                view.setNumber(randomDisk.getNumber());
                view.setNumberColor(getDiskColor(complementaryDisk));

                break;
        }
    }

    private int getDiskColor(Disk disk) {
        int number = disk.getNumber();
        switch (number) {
            case 1:
                return R.color.orange;
            case 2:
                return R.color.yellow;
            case 3:
                return R.color.red;
            case 4:
                return R.color.blue;
            case 5:
                return R.color.green;
            default:
                return R.color.black;
        }
    }

    public void onBackPressed() {
        view.stopSound();
        view.goBack();
    }
}
