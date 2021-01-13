package usersinterface.sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Say 'Hello'!");
        Label lbl1 = new Label("Input your name:");
        Label lbl2 = new Label();
        TextField txt = new TextField();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if ("".equals(txt.getText())) {
                    lbl2.setText("Hello World!");
                } else {
                    lbl2.setText("Hello " + txt.getText() + "!");
                }
            }
        });

        GridPane root = new GridPane();
        root.add(lbl1, 0, 0);
        root.add(txt, 1, 0);
        root.add(btn, 1, 1);
        root.add(lbl2, 1, 2);
        root.setHgap(20);
        root.setVgap(10);

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
