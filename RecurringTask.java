package com.example.demoandroid;

import android.util.Log;

import java.util.Calendar;

public class RecurringTask implements Task{

    public static final String TAG = "RecurringTask";
    String name;
    Long interval;
    int count;

    public RecurringTask(String name,  long interval, int count){
        this.name = name;
        this.interval = interval;
        this.count = count;
    }
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        runInTimeInterval();
    }

    public void runInTimeInterval(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    int number = 1;
                    for(int i = 0; i<count;i++){
                        try {
                            Thread.sleep(interval);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, name + " " + number++ + " is running");
                    }
                }
            }
        }).start();

    }
}
