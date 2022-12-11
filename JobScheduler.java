package com.example.demoandroid;

import android.util.Log;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class JobScheduler {
   public static final String TAG = "JobScheduler";
    private final int capacity;
    private final boolean running = false;

    private PriorityBlockingQueue<Task> queue;

    public JobScheduler(int capacity){
        this.capacity = capacity;
        queue = new PriorityBlockingQueue<Task>(capacity, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return 0;
            }
        });
    }


    public void addTask(Task task){
        if(queue.size()<capacity){

            if(task instanceof SimpleTask){
                Log.d(TAG, ((SimpleTask)task).getName()+ " adding in queue");
            }

            if(task instanceof TimedTask){
                Log.d(TAG, ((TimedTask)task).getName()+ " adding in queue");
            }
            if(task instanceof RecurringTask){
                Log.d(TAG, ((RecurringTask)task).getName()+ " adding in queue");
            }
            queue.add(task);
        } else{
            if(task instanceof SimpleTask){
                Log.d(TAG, ((SimpleTask)task).getName()+ " queue is full");
            }

            if(task instanceof TimedTask){
                Log.d(TAG, ((TimedTask)task).getName()+ " queue is full");
            }
            if(task instanceof RecurringTask){
                Log.d(TAG, ((RecurringTask)task).getName()+ " queue is full");
            }

        }
    }


    public void execute() throws InterruptedException{
        while(!queue.isEmpty()){
            Task task = queue.take();
            if(task instanceof SimpleTask){
                Log.d(TAG, ((SimpleTask)task).getName()+ " removed from queue");
            }

            if(task instanceof TimedTask){
                Log.d(TAG, ((TimedTask)task).getName()+ "  removed from queue");
            }
            if(task instanceof RecurringTask){
                Log.d(TAG, ((RecurringTask)task).getName()+ "  removed from queue");
            }
            if(task != null){
                task.run();
            }
        }
    }

}
