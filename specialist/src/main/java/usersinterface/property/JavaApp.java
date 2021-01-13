package usersinterface.property;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class JavaApp {

    public static void main(String[] args) {

        DemoProperty dp = new DemoProperty();
        dp.setK(11.2);
        dp.setK(-.7);

        DoubleProperty d = new SimpleDoubleProperty();
        d.bind(dp.getKProperty());

        System.out.println("d = " + d.get());

    }

}

class DemoProperty {
    private DoubleProperty k = new SimpleDoubleProperty();

    public DemoProperty() {
        k.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("oldValue = " + number + ", newValue = " + t1);
            }
        });
    }

    public void setK(double k) {
        this.k.set(k);
    }

    public double getK() {
        return k.get();
    }

    public DoubleProperty getKProperty() {
        return k;
    }
}
