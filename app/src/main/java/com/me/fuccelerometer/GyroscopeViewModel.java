package com.me.fuccelerometer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GyroscopeViewModel extends ViewModel {
    public final MutableLiveData<String> gyroX = new MutableLiveData<String>();
    public final MutableLiveData<String> gyroY = new MutableLiveData<String>();
    public final MutableLiveData<String> gyroZ = new MutableLiveData<String>();

    public void SetAll(double newX, double newY, double newZ) {
        gyroX.setValue(convertDouble(newX));
        gyroY.setValue(convertDouble(newY));
        gyroZ.setValue(convertDouble(newZ));
    }

    public LiveData<String> getGyroX() {
        return gyroX;
    }
    public LiveData<String> getGyroY() {
        return gyroY;
    }
    public LiveData<String> getGyroZ() {
        return gyroZ;
    }

    private String convertDouble(double d) {
        return d+"";
    }
}