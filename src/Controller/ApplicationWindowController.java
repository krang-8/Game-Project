package Controller;

/**
 * ApplicationWindowController for the FXML file in the view.javafx package
 */

import Resources.SpriteAnimation;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;


public class ApplicationWindowController {

    SpriteAnimation icon;
    /***************************
     * iconHolder Handler
     *
     * Linking the ImageView to this controller
     * <p>
     * Setting the handler to animate it using
     * class CustomAnimation
     * <p>
     * Setting another Handler for when the mouse
     * exits the icon holder
     *
     * @id iconHolder
     * @handle playAnimation()
     * @handle stopAnimation()
     ***************************/
    @FXML
    private ImageView iconHolder; //Value injected by FXMLLoader
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
    private void playAnimationRight() {
        icon = new SpriteAnimation(iconHolder);
        icon.getAnimationRight().play();

    }

    @FXML
    private void stopAnimation() {
        icon.getAnimationRight().stop();
    }

    @FXML
    private void showMenu() {
        menuBar.setOpacity(1.0);
    }

    @FXML
    private void hideMenu() {
        menuBar.setOpacity(0.0);
    }


}
