package com.example.demoandroid;

import android.util.Log;

public class SimpleTask implements Task{
    public static final String TAG = "SimpleTask";
    String name;
    public SimpleTask(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        runNow();
    }

    public void runNow() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    Log.d(TAG,  name + " is running");
                }

            }
        }).start();

    }
}
