package View;

/**************************************
 *class ApplicationWindow
 *
 * This class will create the view for the main menu
 * when this Project is started this view is the first
 * to be displayed.
 *
 * Starting a new Game will proceed to Create and 'Start the Game'
 * Current Working version has the Game window in SWING
 * and the Main Menu window in JAVAFX
 **************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class ApplicationWindow extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        /*
         * Load the path to the FXML File
         */

        FXMLLoader loadApplicationWindow = new FXMLLoader();
        loadApplicationWindow.setLocation(getClass().getResource("ApplicationWindowFXML.fxml"));
        AnchorPane root = loadApplicationWindow.load();

        /*
         * Set the Scene with the details in the FXML and show
         */

        Scene scene = new Scene(root, 800, 800);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("{Un}-Titled Game");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}