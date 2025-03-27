package com.me.fuccelerometer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccelerometerViewModel extends ViewModel {
    public final MutableLiveData<String> accelX = new MutableLiveData<String>();
    public final MutableLiveData<String> accelY = new MutableLiveData<String>();
    public final MutableLiveData<String> accelZ = new MutableLiveData<String>();

    private double prevX = 0.0;
    private double prevY = 0.0;
    private double prevZ = 0.0;

    public void FilterGravity(double newX, double newY, double newZ) {
        final double ALPHA = 0.5;

        accelX.setValue(convertDouble((prevX * ALPHA + (1 - ALPHA) * newX)));
        accelY.setValue(convertDouble((prevY * ALPHA + (1 - ALPHA) * newY)));
        accelZ.setValue(convertDouble((prevZ * ALPHA + (1 - ALPHA) * newZ)));

        prevX = newX;
        prevY = newY;
        prevZ = newZ;
    }



    public LiveData<String> getAccelX() {
        return accelX;
    }
    public LiveData<String> getAccelY() {
        return accelY;
    }
    public LiveData<String> getAccelZ() {
        return accelZ;
    }

    private String convertDouble(double d) {
        return d+"";
    }
}