package Controller;

/**
 * ApplicationWindowController for the FXML file in the view.javafx package
 */

import Resources.SpriteAnimation;
import View.swing.Platformer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ApplicationWindowController {


    /***************************
     * iconHolder Handler
     *
     * Setting the handler to animate it using
     * class CustomAnimation
     * Fired onMouseEntered (ImageView)
     *
     * Setting another Handler for when the mouse
     * exits the Group
     * Fired onMouseExited (Group)
     *
     * @id iconHolder
     * @handle playAnimation()
     * @handle stopAnimation()
     ***************************/
    SpriteAnimation icon;

    @FXML
    private ImageView iconHolder; //Value injected by FXMLLoader


    @FXML
    private void playAnimationRight() {
        icon = new SpriteAnimation(iconHolder);
        icon.getAnimationRight().play();
    }

    @FXML
    private void stopAnimation() {
        icon.getAnimationRight().stop();
    }


    /***************************
     * menuBar Handler
     *
     * Appear onMouseEntered its Parent (VBox)
     * @handle showMenu()
     *
     * Hide onMouseExited its Parent (VBox)
     * @handle hideMenu()
     ***************************/
    @FXML
    private MenuBar menuBar; //Value injected by FXMLLoader

    @FXML
    private void showMenu() {
        menuBar.setOpacity(1.0);
    }

    @FXML
    private void hideMenu() {
        menuBar.setOpacity(0.0);
    }


    /***************************
     * startButton Handler
     *
     * onMouseClicked
     * @handle startGame()
     *
     * onMouseEntered
     * Change the Appearance of the Background of AnchorPane
     * Hide the menuBar and the titleTextBox
     * @handle startButtonEntered()
     *
     * onMouseExited
     * Revert Changes
     * @handle startButtonExited()
     ***************************/
    @FXML
    private Button startButton; //Value injected by FXMLLoader

    @FXML
    private AnchorPane anchorPane; //Value injected by FXMLLoader

    @FXML
    private Label titleLabel; //Value injected by FXMLLoader

    @FXML
    private void startGame(ActionEvent e) {
        ((Stage) ((Button) e.getSource()).getScene().getWindow()).setIconified(true); // Minimize Window to Icon
        Platformer platform = new Platformer(); //When the User wants to start the game we will hide the Javafx window, and start the Swing Platformer


    }

    @FXML
    private void startButtonEntered() {
        anchorPane.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 12% , repeat, #FFFFFF, #000000, #fffaf0);");
        menuBar.setOpacity(0.0);
        titleLabel.setOpacity(0.0);


    }

    @FXML
    private void startButtonExited() {
        anchorPane.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 12% , repeat, #fffaf0, #008080, #90ee90);");
        titleLabel.setOpacity(1.0);
    }


}
