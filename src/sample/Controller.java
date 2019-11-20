package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller extends Main{

    @FXML
    HBox mainHbox;

    @FXML
    Pane mainPane;

    @FXML
    VBox mainVbox;

    @FXML
    Button btntopage2;

    @FXML
    void gotopagetwo(ActionEvent event) throws IOException {
        Main main = new Main();
        Page2 page2 = new Page2(main.mainStage);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("page2.fxml"));
        fxmlLoader.setController(page2);

        sharescene(fxmlLoader.load());
    }

    void sharescene(HBox content){
        this.mainHbox.getChildren().clear();
        this.mainHbox.getChildren().add(content);
    }

    @FXML
    void initialize(){

        Main main = new Main();
        System.out.println(main.mainStage);

//        for (int i = 0; i < 5; i++) {
//            HBox row = new HBox(10);
//            row.setAlignment(Pos.CENTER);
//            for (int j = 0; j < 5; j++) {
//                Pane pane = new Pane();
//                pane.setPrefSize(200, 200);
//                if ((j + i) % 2 == 0){
//                    pane.setStyle("-fx-background-color: blue; -fx-margin: 10px;");
//                }else{
//                    pane.setStyle("-fx-background-color: green; -fx-margin: 10px;");
//                }
//                ImageView imageView = new ImageView(new Image("http://icons.iconarchive.com/" +
//                        "icons/kidaubis-design/cool-heroes/128/Ironman-icon.png"));
//                pane.getChildren().add(imageView);
//
//                row.getChildren().addAll(pane);
//
//                System.out.println(i + j + " "+ (j +i) % 2);
//            }
//            System.out.println("\n");
//            mainVbox.getChildren().add(row);
//        }



    }

    public void pub(){
        System.out.println("from parent");
    }
}
