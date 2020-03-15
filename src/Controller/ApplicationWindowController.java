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
    private Button startButton;      //Value injected by FXMLLoader

    @FXML
    private AnchorPane anchorPane;   //Value injected by FXMLLoader

    @FXML
    private Label titleLabel;        //Value injected by FXMLLoader

    private double radius = 14;             //Used only for illusion()
    private boolean zoomDirection = true;   //Used only for illusion()
    private double zoomSpeed = 0.5;         //Used to slow or hasten the 'zoom' in illusion()
    private boolean backgroundColor = true; //Used to determine what the current color of the background is. (true = green/false = black)


    @FXML
    private void startGame(ActionEvent e) {
        ((Stage) ((Button) e.getSource()).getScene().getWindow()).setIconified(true); // Minimize Window to Icon
        Platformer platform = new Platformer(); //When the User wants to start the game we will hide the Javafx window, and start the Swing Platformer


    }

    @FXML
    private void startButtonEntered() {
        menuBar.setOpacity(0.0);
        titleLabel.setOpacity(0.0);
        anchorPane.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius " + radius + "%, repeat, #FFFFFF, #000000, #fffaf0);");
        backgroundColor = false;


    }

    @FXML
    private void startButtonExited() {
        titleLabel.setOpacity(1.0);
        anchorPane.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius " + radius + "% , repeat, #fffaf0, #008080, #90ee90);");
        backgroundColor = true;
    }


    /**
     * onMouseMove
     * <p>
     * anytime the mouse moves update the radius
     * for the background
     * <p>
     * fired onMouseMove on
     * anchorPane
     * startButton
     * iconHolder
     */
    @FXML
    private void illusion() {
        //Determining weather it is to zoom in or out and if it is time to reverse zoom direction...
        if (zoomDirection) {
            radius += zoomSpeed;
        } else {
            radius -= zoomSpeed;
        } //Increment radius up or down depending on zoomDirection
        if (radius > 50 || radius < 0.25) {
            zoomDirection = !zoomDirection;
        } //Switch increment value at radius = (0 or 100)

        /*
         *Determining zoom speed
         * If radius is lower than 30 we want a smaller zoomSpeed
         *      If radius is lower than or equal to 5.0 we want an even smaller zoomSpeed
         *
         * if radius is higher than 30 we want a faster zoomSpeed
         */
        if (radius < 30) {
            if (radius <= 5.0) {
                zoomSpeed = 0.03125;
            } else {
                zoomSpeed = 0.25;
            }
        }
        if (radius >= 30) {
                zoomSpeed = 5.0;
            }


            System.out.println(radius);

            //Controlling which background the zoom is applied to...
            if (backgroundColor) //If it is currently the Main Background we set the background and update the radius of that background
            {
                anchorPane.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius " + radius + "%, repeat, #fffaf0, #008080, #90ee90);");
            } else                 //If it is the Black Background we do the same but for the Black one
            {
                anchorPane.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius " + radius + "%, repeat, #FFFFFF, #000000, #fffaf0);");
            }

        }

    }

