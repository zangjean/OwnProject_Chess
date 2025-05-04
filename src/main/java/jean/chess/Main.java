package jean.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import jean.chess.model.home_page.HomePage;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String path_home_page = "/jean/chess/view/home_page/home_page.fxml";
        String path_sheetstyle = "/jean/chess/styles/home_page.css";

        HomePage homePage = new HomePage(1300, 700, 2,path_home_page,path_sheetstyle);
        FXMLLoader loader = new FXMLLoader(homePage.getUrl_home_page());
        primaryStage.setTitle("Chess");
        Scene scene = new Scene(loader.load(), homePage.getPref_width(), homePage.getPref_height());
        scene.getStylesheets().add(homePage.getUrl_sheetstyle().toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);

    }

    public static void main(String[] args) {
        launch();
    }



}
