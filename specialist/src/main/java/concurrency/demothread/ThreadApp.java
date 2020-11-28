package concurrency.demothread;

public class ThreadApp {

    public static void main(String[] args) {

        System.out.println("Start of " + Thread.currentThread().getName());

        HelloThread thread = new HelloThread();
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End of main()");

    }

}
