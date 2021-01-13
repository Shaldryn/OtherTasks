package usersinterface.threadfx;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class JavaAppFx extends Application {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of main()");

        MyTask task = new MyTask();
        new Thread(task).start();
        DoubleProperty progress = new SimpleDoubleProperty();
        progress.bind(task.progressProperty());

        while (!task.isDone()) {
            Thread.sleep(300);
            System.out.println(progress.get());
        }

        System.out.println("End of main()");
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class MyTask extends Task<Void> {

    @Override
    protected Void call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            updateProgress(i + 1, 10);
        }
        return null;
    }

    @Override
    protected void succeeded() {
        System.out.println("End of MyTask");
    }
}
