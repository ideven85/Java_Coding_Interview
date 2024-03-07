package com.cleo.priorityQueueDesignPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@AllArgsConstructor
@Getter

/**
 * Priority Based Scheduler...Basically a max heap
 */
public class PriorityBasedScheduler<T extends Comparable<T>> {

    private final List<T> tasks;
    private  int numberOfTasks;



    public PriorityBasedScheduler() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(T task){
        tasks.add(task);
        numberOfTasks++;
        maxHeapIfyUp();

    }

    public T removeTask(){
        if(isEmpty())
            return null;
        var root = tasks.get(0);
        tasks.set(0,tasks.get(numberOfTasks-1));
        --numberOfTasks;
        maxHeapIfyDown();
        return root;

    }
    public boolean isEmpty(){
        return numberOfTasks<=0;
    }

    public void maxHeapIfyUp(){
        int childIndex=numberOfTasks-1;
        int parentIndex=(childIndex-1)/2;
        while(childIndex>0){
            T childElement = tasks.get(childIndex);
            T parentElement = tasks.get(parentIndex);
            if(childElement.compareTo(parentElement)>=0) {
                tasks.set(childIndex,parentElement);
                tasks.set(parentIndex,childElement);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else
                return;
        }
    }

    /*public void swap(int child, int parent){
        tasks.set(child,tasks.get(parent));
        tasks.set(parent,tasks.get(child));
    }*/

    public void maxHeapIfyDown(){
        int parentIndex = 0, childIndex1 = 1, childIndex2 = 2;
        while (childIndex2 < numberOfTasks && ((tasks.get(parentIndex).compareTo(tasks.get(childIndex1))<=0) || (tasks.get(parentIndex).compareTo(tasks.get(childIndex2))<=0))) {
            int minIndex;
            if (tasks.get(childIndex1).compareTo(tasks.get(childIndex2))>=0) {
                minIndex = childIndex1;
            } else minIndex = childIndex2;
            T temp = tasks.get(parentIndex);
            tasks.set(parentIndex, tasks.get(minIndex));
            tasks.set(minIndex, temp);
            parentIndex = minIndex;
            childIndex1 = parentIndex * 2 + 1;
            childIndex2 = childIndex1 + 1;
        }
    }



}
