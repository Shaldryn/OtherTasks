package concurrency.lab_1_threads.rw;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class RW {

    public static void main(String[] args) throws Exception {
        Data d = new Data();

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            es.submit(new WorkWData(d));

        TimeUnit.SECONDS.sleep(3);
        es.shutdown();
        es.awaitTermination(10000, TimeUnit.MILLISECONDS);
    }
}

class WorkWData implements Runnable {
    Data obj;

    WorkWData(Data d) {
        obj = d;
    }

    public void run() {
        int n;
//        synchronized (obj) {
        n = obj.read();
        System.out.println("First read" + " " + Thread.currentThread().getName() + " " + Integer.toString(n));
        obj.write();
        System.out.println("Write ... " + " " + Thread.currentThread().getName() + " " + Integer.toString(n));
        n = obj.read();
        System.out.println("Second read" + " " + Thread.currentThread().getName() + " " + Integer.toString(n));
//        }
    }
}

class Data {
    private int count = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock rl = lock.readLock();
    private Lock wl = lock.writeLock();


    int read() {
        try {
            rl.lock();
            int n = count;
            TimeUnit.MILLISECONDS.sleep(400);
            count = n;
        } catch (InterruptedException ex) {
        } finally {
            rl.unlock();
        }

        return count;
    }

    void write() {
        try {
            wl.lock();
            int n = count;
            TimeUnit.MILLISECONDS.sleep(400);
            n++;
            count = n;
        } catch (InterruptedException ex) {
        } finally {
            wl.unlock();
        }
    }
}
