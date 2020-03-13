package Controller;

/**
 * ApplicationWindowController for the FXML file in the view.
 */

import Resources.SpriteAnimation;
import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class ApplicationWindowController {


    private int cellDimensions = 1024; // Used for Sprite Animation
    private Animation animation;

    /**
     * Linking the ImageView to this controller
     * <p>
     * Setting the handler to animate it using
     * class SpriteAnimation
     * <p>
     * Setting another Handler for when the mouse
     * exits the icon holder
     *
     * @id iconHolder
     * @handle playAnimation()
     * @handle stopAnimation()
     */
    @FXML
    private ImageView iconHolder;


    @FXML
    private void playAnimation() {
        //Construct the SpriteAnimation
        animation = new SpriteAnimation(
                iconHolder,
                Duration.millis(500), /* This set the speed at which it cycles through the cells*/
                3,
                2,
                0, 0,   /* We have to set the cycle to start at the cell in row 1 col 1*/
                cellDimensions, cellDimensions
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

    }

    @FXML
    private void stopAnimation() {
        animation.stop();
    }


}
