package sample;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Page2 extends Controller implements Initializable {
    Stage primaryStage;

    public Page2(Stage stage) {
        primaryStage = stage;
    }

    @FXML
    private HBox mainHboxPage2;

    @FXML
    void gotopagetwo(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        Rectangle2D screenbound = Screen.getPrimary().getVisualBounds();
        System.out.println(screenbound.getHeight());
        pub();

        mainHboxPage2.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("oke");
            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                System.out.println("oke");



                ConnectionClass connectionClass = new ConnectionClass();
                Connection connection = connectionClass.getConnection();

                System.out.println(connection);

                try {
                    String sql = "SELECT * FROM data_napi";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet rs = statement.executeQuery();

                    while (rs.next()){
                        System.out.println(rs);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }
        };
        Thread queryThread = new Thread(task);
        queryThread.start();
    }
}
