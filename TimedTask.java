package com.example.demoandroid;

import android.util.Log;

public class TimedTask implements Task{
    public static final String TAG = "TimedTask";
    String name;
    Long delay;
    public TimedTask(String name,  long delay){
        this.name = name;
        this.delay = delay;
    }
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        runAfterDelay();
    }


    public void  runAfterDelay(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG,  name + " is running");
                }

            }
        }).start();
    }
}
