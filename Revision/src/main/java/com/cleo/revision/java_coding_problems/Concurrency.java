package com.cleo.revision.java_coding_problems;


public class Concurrency {

    public void newThread(){
        Thread t = new Thread(()->{});
        System.out.println("New Thread:" + t.getName() + " " + t.getState());

    }

    public void runnableThread(){
        Thread t=  new Thread(()->{});
        t.start();
        System.out.println("Runnable Thread: " + t.getName() + " " + t.getState());
    }
    public void blockedThread() throws InterruptedException{
        Thread t1 = new Thread(new SyncCompute());
        Thread t2 = new Thread(new SyncCompute());
        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);
        System.out.println("Blocked Thread: " + t1.getName() + " is in blocked thread method " + t1.getState());
        System.out.println("Blocked Thread: " + t2.getName() + " is in blocked thread method " + t2.getState());

        System.exit(0);
    }

    static class SyncCompute implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName() + " is in run() method");
            System.out.println(computeFibonacci(10000));
        }
        public static synchronized int computeFibonacci(int n){
            return n<2?n:computeFibonacci(n-1)+computeFibonacci(n-2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Concurrency c = new Concurrency();
        c.newThread();
        c.runnableThread();
        c.blockedThread(); //To Invoke to check for thread state
    }


}
