package Resources;

/**
 * This class Simply Creates an object to hold the Animated ImageViews from the 'CharSpriteSheet.png'
 * Only Construct a single SpriteImageView for a player. This class has 2 animated actions and has
 * 1 still view - where the sprite is always facing the right
 * <p>
 * * Static variables:
 * *  -cellDimension is only used to get the Width and height of each sprite
 * *
 * * Instance variables:
 * *  are created and set with an animation on construction
 * *  stand has no animation and is simply the standing sprite
 * *  spriteSheet is only used to create the instance variables
 * *
 * * Methods:
 * *
 * *  constructor:
 * creates an object that houses the different animation options
 * *  getters:
 * *      used to get the animations from the object when attempting to move the player
 * *  setters:
 * *      used solely by the constructor to set up the Instance variables with the ImageView + animation
 * *
 */

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteImageView {

    /*
     * static class variables
     */
    private static int cellDimensions = 1024;


    /*
     * class instance variables
     */
    private Image spriteSheet =
            new Image("file:CharSpriteSheet.png");
    private ImageView animationLeft;
    private ImageView animationRight;
    private ImageView animationStand;

    /*
     * constructor
     */
    public SpriteImageView() {

        this.setAnimationLeft();
        this.setAnimationRight();
        this.setAnimationStill();

    }

    /**********************
     * setter methods
     *
     * Used solely by the constructor of this class
     * Initializes the Instance Variables, Gives them
     * a ViewPort and an Animation
     **********************/
    private void setAnimationStill() {
        // NOTE still does not need an Animation so just providing the still
        animationStand.setImage(spriteSheet);
        animationStand.setViewport(new Rectangle2D(0, 0, cellDimensions, cellDimensions));


    }

    private void setAnimationRight() {
        animationRight.setImage(spriteSheet);
        animationStand.setViewport(new Rectangle2D(0, 0, cellDimensions, cellDimensions));

        //Construct the SpriteAnimation
        final Animation animation = new SpriteAnimation(
                animationRight,
                Duration.millis(100), /* This set the speed at which it cycles through the cells*/
                3,
                2,
                0, 0,   /* We have to set the cycle to start at the cell in row 1 col 1*/
                cellDimensions, cellDimensions
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

    }

    private void setAnimationLeft() {
        animationLeft.setImage(spriteSheet);
        animationLeft.setViewport(new Rectangle2D(0, 0, cellDimensions, cellDimensions));

        //Construct the SpriteAnimation
        final Animation animation = new SpriteAnimation(
                animationLeft,
                Duration.millis(100), /* This set the speed at which it cycles through the cells*/
                3,
                2,
                cellDimensions * 2, cellDimensions * 2,   /* We have to set the cycle to start at the cell in row 2 col 2   */
                cellDimensions, cellDimensions
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    /*****************************
     * getter methods
     *
     * To get the Animated ImageViews of the player sprite
     *
     * @return ImageView to display
     ******************************/
    public ImageView getAnimationLeft() {
        return animationLeft;
    }

    public ImageView getAnimationRight() {
        return animationRight;
    }

    public ImageView getAnimationStand() {
        return animationStand;
    }


}
