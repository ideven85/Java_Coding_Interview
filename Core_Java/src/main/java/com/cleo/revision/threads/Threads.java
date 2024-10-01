package com.cleo.revision.threads;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class SimpleThread{

    private static  boolean isRequested;
    private static synchronized void request_stop(){
        isRequested=true;
    }
    private static synchronized boolean stopRequest(){
        return isRequested;
    }
    private static int counter=0;
    public static void stop_thread_background() throws InterruptedException{
        Thread backgroundThread = new Thread(() ->{
            int i=0;
            if(!isRequested)
            while(true){
                i++;
                System.out.print(i + " ");
            }

        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        //System.out.print("\t"+TimeUnit.SECONDS+" ");
        isRequested=true;
      //  stopRequest();

    }

}

public class Threads {

    public static void main(String[] args) {
        try{
            SimpleThread.stop_thread_background();
            System.out.println(new Date());
        }catch (InterruptedException ie){
            System.out.println(ie.getMessage());
        }

    }

}
