package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public Stage mainStage ;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainStage = primaryStage;
        mainStage.setTitle("Hello World");
        mainStage.setScene(new Scene(root, 300, 275));
//        mainStage.setMaximized(true);
        mainStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
