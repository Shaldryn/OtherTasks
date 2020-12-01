package concurrency.demosynchronized2;

public class SynchApp {

    public static void main(String[] args) throws InterruptedException {

        Monitor mon = new Monitor();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("1 - " + i);
                    if (i >= 50) { //if избыточен
                        synchronized (mon) {
                            mon.x = i;
                            mon.notify();
                        }
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (mon) {
                        while (mon.x < 50) mon.wait();
                    }
                } catch (InterruptedException ex) {

                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("2 - " + i);
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }

}
