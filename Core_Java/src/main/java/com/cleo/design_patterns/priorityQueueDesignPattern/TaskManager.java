package com.cleo.design_patterns.priorityQueueDesignPattern;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class TaskManager {

    private final PriorityBasedScheduler<Task> priorityBasedScheduler=new PriorityBasedScheduler<>();

    public void publishTask(Task task){
        priorityBasedScheduler.addTask(task);
    }
    public Task receiveTask(){
        if(priorityBasedScheduler.isEmpty())
            return null;
        return priorityBasedScheduler.removeTask();
    }

}
