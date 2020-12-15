package concurrency.demopoolthreads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class PoolApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            results.add(exec.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " - done");
                    return Thread.currentThread().getName();
                }
            }));
        }

        exec.shutdown();

        for (Future<String> result :
                results) {
            System.out.println("Got result: " + result.get());
        }

        System.out.println("End of main()");
    }

}
