package concurrency.demothread3;

public class CancelThread implements Runnable {

    private Thread self;
    private static int threadCounter;
    private int threadID;
    private int counter;
    private volatile boolean canWork;

    public CancelThread() {
        threadID = threadCounter++;
        self = new Thread(this, "CancelThread-" + threadID);
//        self.start();
    }

    public int start() {
        canWork = true;
        self.start();
        return counter;
    }

    public int stop() {
        System.out.println("Sending stop!");
        canWork = false;
        return counter;
    }

    public int interrupt() {
        System.out.println("Sending interrupt!");
        self.interrupt();
        return counter;
    }

    public int join(int ms) throws InterruptedException {
        self.join(ms);
        return counter;
    }

    @Override
    public void run() {
//        1st version
//        while (true) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException ex) {
////                System.out.println("You will not stop me!!!");
//                System.out.println("Interrupting");
//                break;
//            }
//            counter++;
//        }
//        2nd version
        while (canWork) {
            counter++;
        }
    }
}
