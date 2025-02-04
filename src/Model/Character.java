package Model;



public class Character {
    // This is the Superclass for Visual.ProjectGame.Player and Boss classes

    // Instance variables
    private double x_cord = 0.0;
    private double y_cord = 0.0;
    private int maxHealth;
    private int health;
    private String name;
    private boolean state;
    private final double WIDTH = 0.5; //temporary height and width, will probably be changed later to adjust size
    private final double HEIGHT = 1.0;


    // Constructor


    public Character(Character original) {
        // Copy of Character to new Character obj
        this.x_cord = original.getX();
        this.y_cord = original.getY();
        this.maxHealth = original.getMaxHealth();
        this.health = original.getHealth();
        this.name = original.getName();
        this.state = original.getState();
    }

    public Character(String name) {
        // Simple constructor
        this.name = name;
    }

    // Methods

    //Getters
    public double getX() {
        // Returns any Character object's x_cord
        return x_cord;
    }

    public double getY() {
        // Returns any Character object's y_cord
        return y_cord;
    }

    public int getMaxHealth() {
        // Returns the Character objects maxHealth;
        return maxHealth;

    }

    public int getHealth() {
        // Returns any Character object's health
        return health;
    }

    public String getName() {
        // Returns any Character object's name
        return name;
    }

    public boolean getState() {
        // Gets weather or not the character is alive or dead
        return state;
    }

    public String getCords() {
        // Returns the String for current cords in form " (x,y) "

        return this.getName() + "'s Current Coordinates: (" + this.getX() + "," + this.getY() + ")";
    }


    //Setters
    public void setName(String name) {
        //Sets the name for the object
        this.name = name;
    }

    public void setMaxHealth(int maxHealth) {
        //Sets Maximum health value
        //Useful for healing and for boss fighting
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        // Setting current health value
        this.health = health;
    }

    public void increment_health(int increment) {
        //Increments health up or down - Used for damage method later...

        this.health += increment;
    }

    public void setState(boolean changeTo) {
        // Changes the Value of State variable showing the object should be dead or alive
        this.state = changeTo;
    }

    public void reverseState() {
        // Reverses the state variable of any character type object
        if (this.state) {
            this.state = false;
        } else {
            this.state = true;
        } //If state == true then {switch to false}else{switch to true}
    }


    public void incrementX(double increment, boolean print) throws InterruptedException {
        // Useful for movement methods for Visual.ProjectGame.Player and Boss class
        this.x_cord += increment;
        Thread.sleep(250);
    }

    public void incrementY ( double increment) throws InterruptedException {
        //Useful for jumping and falling movements for player
        this.y_cord += increment;
        Thread.sleep(250);
    }

    public void setTo ( double newX, double newY){
        // Moves the X cord and Y cord to the new location
        // Sort of like a 'teleport'
        this.x_cord = newX;
        this.y_cord = newY;

        }
    }


