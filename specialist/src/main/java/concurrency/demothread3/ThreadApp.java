package concurrency.demothread3;

public class ThreadApp {
    public static void main(String[] args) throws InterruptedException {
        CancelThread thread = new CancelThread();

        System.out.println("start() = " + thread.start());
        System.out.println("join() = " + thread.join(1000));
//        System.out.println("interrupt() = " + thread.interrupt());
        System.out.println("stop() = " + thread.stop());
    }
}
