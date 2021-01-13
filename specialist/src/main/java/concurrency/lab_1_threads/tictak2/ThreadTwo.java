package concurrency.lab_1_threads.tictak2;

public class ThreadTwo implements Runnable {
    private Thread thread;
    private Monitor monitor;

    public Thread getThread() {
        return thread;
    }

    public ThreadTwo(Monitor monitor) {
        this.monitor = monitor;
        this.monitor.x = 2;
        thread = new Thread(this);
    }

    public void run() {
//        try {
//            Thread.sleep(1);
//            synchronized (monitor) {
//                monitor.x = 2;
//                monitor.notify();
//                if (i < TicTak.num - 1) {
//                    monitor.wait();
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (monitor.x == 1) {
//            for (int i = 0; i < TicTak.num; i++) {
//                System.out.print(2 + " - ");
//
//            }
//        }
//    }
    }
}
