package Resources;

/**
 * This class Simply Creates an object to hold the Animated ImageViews from the 'CharSpriteSheet.png'
 * Only Construct a single SpriteAnimation for a player. This class has 2 animated actions and has
 * 1 still view - where the sprite is always facing the right
 * <p>
 * * Static variables:
 * *  -@param cellDimension is only used to get the Width and height of each sprite
 * *  -@param spriteSheet is only used to create the instance variables
 * *  -@param frameRate is determined by this class and if needed to modify will modify all animations
 * *
 * * Instance variables:
 * *    Are created and set with the animation on construction
 * *    @param constructor2Used is false if used by the controller else true
 * This is needed to avoid bugs attempting to
 * set the viewport twice
 * *@TODO
 * *    stand animation has yet to get dedicated cells in sprite sheet
 * *    Improve Sprite sheet with more frames of movement
 * *
 * *
 * * Methods:
 * *
 * *  constructor:
 * *      Either be given an object of type ImageView or it will create one by itself
 * *      creates an object that houses the different animation options
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

public class SpriteAnimation {

    /*
     * static class variables
     */
    private static int cellDimensions = 1024;
    private static int frameRate = 500;
    private static Image spriteSheet =
            new Image("file:CharSpriteSheet.png");


    /*
     * class instance variables
     */
    private ImageView spriteImageView;
    private Animation animationLeft;
    private Animation animationRight;
    private Animation animationStand; // @TODO IMPLEMENT
    private boolean constructor2Used;


    /*
     * constructor
     */
    public SpriteAnimation(ImageView aSpriteImageView) {
        //Used to set this animation to an existing ImageView
        constructor2Used = false;
        spriteImageView = aSpriteImageView;
        this.setAnimationLeft();
        this.setAnimationRight();
        this.setAnimationStill();
    }

    public SpriteAnimation() {
        //Used to create the animation without providing a ImageView
        constructor2Used = true;
        this.setAnimationLeft();
        this.setAnimationRight();
        this.setAnimationStill();
    }

    /**********************
     * setter methods
     *
     * For Variables of type Animation the
     * setter methods are used solely by
     * the constructor of this class to
     * Initializes the animations using
     * the provided ImageView control
     **********************/
    private void setAnimationStill() {
        /**
         * @TODO
         *   set up cells with standing sprite frames
         *
         */
        return;
    }

    private void setAnimationRight() {

        if (constructor2Used) {
            spriteImageView.setImage(spriteSheet);
            spriteImageView.setViewport(new Rectangle2D(
                    0, 0,
                    cellDimensions, cellDimensions));
        }

        //Construct the CustomAnimation
        animationRight = new CustomAnimation(
                spriteImageView,
                Duration.millis(frameRate), /* This set the speed at which it cycles through the cells*/
                3,
                2,
                0, 0,   /* We have to set the cycle to start at the cell in row 1 col 1*/
                cellDimensions, cellDimensions
        );
        animationRight.setCycleCount(Animation.INDEFINITE);
    }

    private void setAnimationLeft() {

        if (constructor2Used) {
            spriteImageView.setImage(spriteSheet);
            spriteImageView.setViewport(new Rectangle2D(
                    cellDimensions * 2, cellDimensions * 2,
                    cellDimensions, cellDimensions));
        }

        //Construct the CustomAnimation
        animationLeft = new CustomAnimation(
                spriteImageView,
                Duration.millis(frameRate), /* This set the speed at which it cycles through the cells*/
                3,
                2,
                cellDimensions * 2, cellDimensions * 2,   /* We have to set the cycle to start at the cell in row 2 col 2   */
                cellDimensions, cellDimensions
        );
        animationLeft.setCycleCount(Animation.INDEFINITE);
    }

    /*****************************
     * getter methods
     *
     * (1)
     * To get the Animations of the player sprite
     * @return animation to display
     *
     * (2)
     * Get the ImageView Used for the Animations
     * @return ImageView (May not be needed)
     ******************************/
    public Animation getAnimationLeft() {
        return animationLeft;
    }

    public Animation getAnimationRight() {
        return animationRight;
    }

    public Animation getAnimationStand() {
        return animationStand;
    }

    public ImageView getSpriteImageView() {
        return spriteImageView;
    }


}
