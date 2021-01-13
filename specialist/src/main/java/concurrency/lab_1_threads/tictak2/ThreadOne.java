package concurrency.lab_1_threads.tictak2;

public class ThreadOne extends Thread {

    private Monitor monitor;

    public ThreadOne(Monitor monitor) {
        this.monitor = monitor;
        this.monitor.x = 1;
    }

    public void run() {


        try {
            for (int i = 0; i < TicTak.num; i++) {
                System.out.print(1 + " - ");
                if (monitor.x == 1 || monitor.x == 3) {
                    synchronized (monitor) {
                        monitor.x = 1;
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
