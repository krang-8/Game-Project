package Model;

import java.util.ArrayList;

public class Player extends Character{

    // The Character that the user will control

    // Instance Variables

    private boolean jumpStatus = true; // If true the Visual.ProjectGame.Player is able to call the Jump method
    private boolean dashStatus = true; // If true the Visual.ProjectGame.Player is able to call the Dash Method
    private boolean crouchStatus = false; // For future implementation; dashing while crouched will result in a side where the players hit box should be halved

    // These will always belong to the Class ----> Potentially modified by POWER_UPS and ITEMS
    private static final double JUMP_HEIGHT = 1.5;
    private static final double ABILITY_SPEED = 0.75;
    // This value is used for the ability functions to change the speed at which a player completes a jump/dash
    private static final double DASH_MULTIPLIER = 3.0;
    // When in a dash PLAYER_SPEED temporarily for the duration of the dash will become PLAYER_SPEED * DASH_MULTIPLIER

    private String playerDirection = "RIGHT"; // "LEFT" = A   "RIGHT" = D
    private double playerSpeed = 1.0;





    // Constructor

    public Player(Character original) {
        // Takes a Character obj and makes it a Visual.ProjectGame.Player obj
        super(original);
    }

    public Player(String name){
        // Default constructor of a Visual.ProjectGame.Player Obj
        super(name); // Call the superclass constructor first
    }

    // Methods

    // Getters

    public boolean getJumpStatus(){
        // Returns the value of jumpStatus
        return jumpStatus;
    }
    public boolean getDashStatus(){
        // Returns the value of dashStatus
        return dashStatus;
    }
    public double getPlayerSpeed(){
        //Returns the Players Speed value
        return playerSpeed;
    }
    public boolean getCrouchStatus() {
        // Return the player crouch Status
        return crouchStatus;
    }
    public String getPlayerDirection(){
        // Return the player playerDirection
        return playerDirection;
    }

    // Setters

    public void setJumpStatus(boolean value){
        // Setting Jump Status
        this.jumpStatus = value;
    }
    public void setDashStatus(boolean value){
        // Setting Dash Status
        this.dashStatus = value;
    }
    public void setCrouchStatus(boolean crouchStatus) {
        this.crouchStatus = crouchStatus;
    }
    public void reverseCrouch() {
        // Reverses the state variable of any player type object

        //If state == true then {switch to false}else{switch to true}
        this.crouchStatus = !this.crouchStatus;
    }
    public void setPlayerDirection(String direction){

        this.playerDirection = direction;
    }


    // Actions
    // KeyBoardInput class will use these methods

    public void jump(ArrayList<Traps> trapList) throws InterruptedException {
        // Current version of this method will instantly move the character to the y_cord + JUMP_HEIGHT... wait a bit and fall back down
        // Version with GUI should gradually raise the players Y value then gradually lower it
        // Currently we do not have ground so when if comes to the fall of the jump it will treat y_cord == 0.0 as the ground
        // Needs to keep x momentum through the jump

        if (crouchStatus){
            System.out.println("Visual.ProjectGame.Player can not jump while crouched..."); return;} // Can't Jump while crouching so we just return

        if(this.getPlayerDirection().equalsIgnoreCase("LEFT") && this.getX() < 4.5){
            // If player attempts to jump into a negative X this will reset the player back to Checkpoint
            System.out.println("That action is forbidden...\n\t Visual.ProjectGame.Player attempting to go outside the bounds of the world\n"+ this.getName() + "'s Current Coordinates: (0.0, 0.0)");
            this.setPlayerDirection("RIGHT");
            Thread.sleep(1500);
            return;
        }

        int directionModifier = 1;
        if (this.getPlayerDirection().equalsIgnoreCase("LEFT")){directionModifier = -1;}
        // is facing left we need to be incrementing out x to the left using negative perTickX values

        double perTickY = ABILITY_SPEED / JUMP_HEIGHT; // This is the value we need to add to the players y_cord each loop
        double perTickX = ABILITY_SPEED / playerSpeed * directionModifier; // This is the value we need to add to the players y_cord each loop
        double initialY = this.getY();
        double initialX = this.getX(); // By the end of the jump action the x value needs to be moved by 2 * PLAYER_SPEED


        while (this.getY() < initialY + JUMP_HEIGHT ){
            // This will loop until the player object's current Y value is equal to or greater than the objects initial Y + JUMP_HEIGHT
            // The rising action of a jump
            // Each loop of this will update the players location gradually upward
            // The value for ABILITY_SPEED; if higher will complete the jump action faster in less frames / Increments
            // Each loop of this will be a single frame in the game
            // ABILITY_SPEED is a variable that we can change later to make this go faster or slower

            this.incrementY(perTickY);
            this.incrementX(perTickX, false);

            System.out.println(this.getCords()); // This is just used for demo purposes in the full game this should display the player on the screen with the new cords
        }

        while (this.getY() > (0.01)){
            // Falling action of a jump

            this.incrementY(-perTickY);
            this.incrementX(perTickX, false);
            System.out.println(this.getCords());
        }
        this.moveValid(trapList);
    }


    public void dash(ArrayList<Traps> trapList,String direction) throws InterruptedException {
        // Potential for KeyBoardInput interaction will allow a player to choose which way to dash
        // Changes the current position of the player with respect to the x_cord after using the dash facing left or right
        this.playerSpeed *= DASH_MULTIPLIER;
        if (playerDirection.toUpperCase().equals("RIGHT")) {
            for (double c = 0; c < this.getPlayerSpeed(); c += 0.25) {
                incrementX(0.25, true);

                System.out.println(getCords());
                if (!this.moveValid(trapList)) {
                    return;
                }
            }
        }

        if (playerDirection.toUpperCase().equals("LEFT")) {
            for (double c = 0; c > -this.getPlayerSpeed(); c -= 0.25) {
                incrementX(-0.25, true);
                System.out.println(getCords());
                if (!this.moveValid(trapList)) {
                    return;
                }
            }
        }

        //Thread.sleep(1000);
        /* Essentially waits a second before resetting playerSpeed to original
         in order for the dash -- > jump combo to work so that jumping after dashing
         will let the player have a further jump
         */
        this.playerSpeed /= DASH_MULTIPLIER;

        /* Changes the current position of the player with respect of the y_cord after using the dash while in air (Usable as a form of double jump)
        if (playerDirection.toUpperCase().equals("UP")) { this.incrementY(DASH_LENGTH); }
            This was meant for a potential jump dash combo but we will instead just implement a double jump
         */
    }

    public void moveRight(ArrayList<Traps> trapList) throws InterruptedException {
        // This will take the objects x_cord and move it according to the Visual.ProjectGame.Player speed to the right
        this.setPlayerDirection("RIGHT");
        for (double c = 0.0; c < this.playerSpeed; c += 0.25) {
            this.incrementX(0.25, true);
            System.out.println(this.getCords());
            if(!this.moveValid(trapList)){
                return;
            }
        }
    }


    public void moveLeft(ArrayList<Traps> trapList) throws InterruptedException {
        // This will like the above method simply add the PLAYER_SPEED to the objects x_cords value
        this.setPlayerDirection("LEFT");
        for (double c = 0.0; c > -this.playerSpeed; c -= 0.25) {

            if(!this.moveValid(trapList)){
                //PreCheck ensuring player is in bounds (not at 0 or lower)
                System.out.println("That action is forbidden...\n\t Visual.ProjectGame.Player attempting to go outside the bounds of the world\n"+ this.getName() + "'s Current Coordinates: (0.0, 0.0)");
                this.setPlayerDirection("RIGHT");
                Thread.sleep(1500);
                return;
            }

            this.incrementX(-0.25, true);
            System.out.println(this.getCords());

            if(!this.moveValid(trapList)){
                //Ensuring player death if they run on trap
                return;
            }
        }
    }

    private void death(Traps t) throws InterruptedException {
        // To check if a player is on a trap
        // This method will get the players current X and Y cords and see if they match any of the Traps in the Trap list
        // If a player is on a trap the Trap's damagePlayer() method will be called on the player


        t.damagePlayer(this); // Visual.ProjectGame.Player will die
        System.out.println("\nOOoOOooOf You have died :( \nReturning you to the start of the level...\n");
        Thread.sleep(2000);
        this.setTo(0,0); // Visual.ProjectGame.Player will be reset to (0,0) the start of the level
        System.out.print(this.getCords());


    }


    public boolean winCheck(double lastFrameX){
        // Check if the player crosses the frame --> will result in a victory dialogue

        if(this.getX() >= lastFrameX){
            // Victory!!!
            System.out.println("YOU JUST WON THE GAME CONGRATS...\n\n\n");
            return true;

        }
        return false;
    }

    public boolean moveValid (ArrayList<Traps> trapList) throws InterruptedException {

        for(Traps t : trapList){
            // Invalid as in You DIE
            if(t.getX_Cord() == this.getX()){
                this.death(t);

                return false;
            }
        }

        // Invalid as in outside of world
        if(this.getX() == 0.0){return false;}
        return true;
    }
}
