package concurrency.demothread2;

public class DemoThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        } catch (InterruptedException e) {

        }

    }
}
