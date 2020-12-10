package concurrency.demosynchronized3;

public class SumThread extends Thread {

    private int pos;

    public SumThread(int pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        for (int i = pos; i < GlobalData.ARRAY_LENGTH; i += GlobalData.THREADS_COUNT) {
            GlobalData.results[pos] += GlobalData.array[i];
        }
    }
}
