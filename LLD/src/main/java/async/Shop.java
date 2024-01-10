package async;

import java.util.concurrent.*;

public class Shop {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future  = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return fib(10);
            }
        });
        System.out.println(factorial(10));
        try{
            //It is a blocking call.. Either it will produce the result or block execution
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        }catch (ExecutionException | InterruptedException | TimeoutException ee){
            ee.printStackTrace();
        }
    }

    private static double fib(int n){
        if(n<2)
            return n;
        return fib(n-1)+fib(n-2);
    }
    private static double factorial(int n){
        return n<2?1:n*factorial(n-1);
    }

}
