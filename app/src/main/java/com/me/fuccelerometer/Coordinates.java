package com.me.fuccelerometer;

public class Coordinates {

    private double x;
    private double y;
    private double z;
    private final boolean isInit;

    public Coordinates(double X, double Y, double Z) {
        x = X;
        y = Y;
        z = Z;
        isInit = true;
    }

    public double X() {
        return x;
    }
    public double Y() {
        return y;
    }
    public double Z() {
        return z;
    }
    public boolean IsInit() {
        return isInit;
    }
    public void SetX(double newX) {
        x = newX;
    }
    public void SetY(double newY) {
        y = newY;
    }
    public void SetZ(double newZ) {
        z = newZ;
    }
    public void SetAll(double newX, double newY, double newZ) {
        x = newX;
        y = newY;
        z = newZ;
    }

}
