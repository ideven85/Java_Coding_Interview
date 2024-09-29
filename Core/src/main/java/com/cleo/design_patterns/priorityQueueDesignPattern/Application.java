package com.cleo.design_patterns.priorityQueueDesignPattern;

public class Application {

    public static void main(String[] args) throws InterruptedException{
        var taskManager = new TaskManager();
        taskManager.publishTask(new Task("First",1));
        taskManager.publishTask(new Task("Second",20));
        taskManager.publishTask(new Task("Third",3));
        taskManager.publishTask(new Task("Fourth",3));
        taskManager.publishTask(new Task("Null",0));

//        for (int i = 0; i < 10; i++) {
//            taskManager.publishTask(new Task("High Priority Task",1));
//        }
        var worker = new BackgroundWorker(taskManager);
        worker.run();
    }
}
