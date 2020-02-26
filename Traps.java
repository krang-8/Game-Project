import java.lang.reflect.Array;
import java.util.ArrayList;

public class Traps {
    /* All traps will be stored into a class environment within an array with their coordinates displayed to world using those coordinates
       The image for all traps will depend on the environment the player is currently in all traps will function in the same manner but differ in appearance
       Types of traps will be (Cactus -> Fire -> Spike -> Icicle) */


    // Instance Variables
    private double x_cord;
    private double y_cord;
    private int damage = 3;
    private String imageFileLocation;
    // This will be used in the future when changing the type of image used for "trap"

    // Constructor
    public Traps(double X, double Y){
        // In the future this constructor will take in the environment object and set the image to the corresponding biome
        this.x_cord = X;
        this.y_cord = Y;
    }

    // Getters

    public double getX_Cord(){
        return x_cord;
    }

    public double getY_Cord(){
        return y_cord;
    }

    public int getDamage(){
        return damage;
    }

    // Setters

    public void setX_cord(double newX){
        this.x_cord = newX;
    }

    public void setY_cord(double newY){
        this.y_cord = newY;
    }
    // Method

    public void damagePlayer(Player user){
        user.increment_health(-this.getDamage());
    }


}
