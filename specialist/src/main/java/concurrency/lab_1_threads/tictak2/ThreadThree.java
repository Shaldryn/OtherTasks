package concurrency.lab_1_threads.tictak2;

public class ThreadThree implements Runnable {
    private Thread thread;
    private Monitor monitor;

    public Thread getThread() {
        return thread;
    }

    public ThreadThree(Monitor monitor) {
        this.monitor = monitor;
        this.monitor.x = 3;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            thread.sleep(2);
            if (monitor.x == 2) {
                for (int i = 0; i < TicTak.num; i++) {
                    System.out.println(3);
                    synchronized (monitor) {
                        monitor.x = 3;
                        monitor.notify();
                        if (i < TicTak.num - 1) {
                            monitor.wait();
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
