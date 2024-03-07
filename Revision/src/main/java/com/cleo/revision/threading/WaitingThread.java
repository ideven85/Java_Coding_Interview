package com.cleo.revision.threading;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;


public class WaitingThread {

    //todo Learn Logger in a non Spring Boot Application
    //private Logger logger = Logger.ROOT_LOGGER_NAME
    public void waitingThread() {
        try {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println((e.getMessage()));
                }
            });
            t.start();
            Thread.sleep(500);
            System.out.println(("Timed Thread State: " + t.getState()));
        }catch (InterruptedException ie){
            System.out.println((ie.getMessage()));
        }
    }

    public static void main(String[] args) {
        WaitingThread timedWaitingThread = new WaitingThread();
        timedWaitingThread.waitingThread();
    }

}
