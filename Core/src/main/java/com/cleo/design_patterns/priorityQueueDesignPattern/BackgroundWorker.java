package com.cleo.design_patterns.priorityQueueDesignPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j

/**
 * Worker Constantly polls TaskManager for highest priority task...
 * And publishes it
 */
public class BackgroundWorker {

    private final TaskManager taskManager;

    //private String MESSAGE="STOP";
    public BackgroundWorker(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void run() throws InterruptedException{

        while(taskManager.receiveTask()!=null){
            var task = taskManager.receiveTask();
            if(task==null){
                System.out.println("Hi");
                System.out.println("No Task Waiting");
                Thread.sleep(200);
            }else{
                processTask(task);
            }
        }
    }
    public void processTask(Task task){
        System.out.println(task.toString());
    }
}
