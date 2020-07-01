package com.umbrella.stfctracker.Structures;

public class Data {
    private static final Data mInstance = new Data();

    private int operationsLevel;

    public static Data getInstance() {
        return mInstance;
    }

    private Data() {
    }

    public void init(int operationsLevel) {
        this.operationsLevel = operationsLevel;
    }

    public int deInit() {
        return operationsLevel;
    }

    public int getOperationsLevel() {
        return operationsLevel;
    }

    public void setOperationsLevel(int operationsLevel) {
        this.operationsLevel = operationsLevel;
    }
}
