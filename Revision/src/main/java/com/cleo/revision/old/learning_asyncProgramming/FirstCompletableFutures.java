package com.cleo.revision.old.learning_asyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstCompletableFutures {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Runnable task = () -> {
			System.out.println("I am running asynchronously in the thread "
					+ Thread.currentThread().getName()+":"+Thread.currentThread().getState().name());
		};
		
		CompletableFuture.runAsync(task);
		
		Thread.sleep(100);
		executor.shutdown();
	}
}
