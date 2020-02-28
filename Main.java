import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    //Variables

    private static Scanner keyboard = new Scanner(System.in);
    private static Player demoPlayer = new Player("Demo1"); // This is the Player object that belongs to this class
    private static MainMenu mainMenu = new MainMenu();
    private static ArrayList<Traps> trapsList = new ArrayList<Traps>();
    private static double lastFrameX = 20; // Once the player crossed this the game is considered won for the demo
    private static boolean gameIsWon = false;
    private static ArrayList<String> worldList = new ArrayList<String>(Arrays.asList("-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"));

    // Methods

    private static void action(Player target, String action) throws InterruptedException {
        // Will take input through the Scanner object and apply the action to the desired object


        // Move Right
        if (action.equalsIgnoreCase("D")) {
            target.moveRight(trapsList);
        }

        // Move Left

        if (action.equalsIgnoreCase("A")) {
            target.moveLeft(trapsList);
        }

        // Jump
        if (action.equalsIgnoreCase("W")) {
            target.jump(trapsList);
        }

        // Dash
        if (action.equalsIgnoreCase("P")) {
            target.dash(trapsList,target.getPlayerDirection());
        }

        // Crouch (This may or may not be of use in the final game)
        if (action.equalsIgnoreCase("S")) {
            target.reverseCrouch();
            System.out.println("Crouch Status: " + target.getCrouchStatus());
        }


    }



    public static String askInput() throws InterruptedException {
        //Prompt the user with input and pass that to the action method

        Thread.sleep(1000);
        System.out.println("\n\nEnter desired direction of movement for " + demoPlayer.getName() + "...(case doesn't matter)\n\tW - Jump: Moves X by 4.5 \n\tA - Move Left: Moves X by 1 to the left\n\tS - Crouch: Halves Width and disables Jump\n\tD - Move Right: Moves X by 1 to the Right\n\tP - Dash: Moves X by 3");
        return keyboard.next();
    }

    public static void toString(ArrayList<Traps> trapList, ArrayList<String> worldList, Player player) {
        // Displays the locations of the traps

        int counter = 0;
        System.out.println("Current World:");
        for(int i = 0; i < lastFrameX * 2; i++){
            // Reset the world list to empty
            worldList.set(i, "-");

        }

        for (Traps b : trapList){
            // Displaying Traps to the world list
            worldList.set((int)(b.getX_Cord() * 2), "X");

        }
        worldList.set((int)(player.getX() * 2), "*");

        for(String s: worldList){
            counter++;
            System.out.print(s + " ");

            if(counter % 10 == 0 && counter % 40 != 0){System.out.print("\n"); // Breaks the world into 5's

            }
        }


    }


    public static void main(String[] args) throws InterruptedException {
// This version of this class will be for DEMO 1 and will be further updated with JAVA FX for future use
// S - Crouch may or may not be implemented in the Final Version of the Game however is included for the purpose of DEMO 1


        // Main menu
        do {
            mainMenu.run();

            // Traps
            trapsList.add(new Traps(2, 0));
            trapsList.add(new Traps(5, 0));
            trapsList.add(new Traps(9, 0));
            trapsList.add(new Traps(14, 0));
            trapsList.add(new Traps(17, 0));
            trapsList.add(new Traps(20, 0));

            //Creating demoPlayer with the user

            // Setting Name
            System.out.println("Please name your Player: ");
            String input = keyboard.next();
            demoPlayer.setName(input);

            // Setting MaxHealth
            demoPlayer.setMaxHealth(3);
            demoPlayer.setHealth(3);
            System.out.println(demoPlayer.getName() + "'s health is currently: " + demoPlayer.getHealth() + "/" + demoPlayer.getMaxHealth());
            Thread.sleep(500);

            // Ability status'
            //Jump
            System.out.println(demoPlayer.getName() + "'s Current Jump Status: " + demoPlayer.getJumpStatus());
            Thread.sleep(500);
            //Dash
            System.out.println(demoPlayer.getName() + "'s Current Dash Status: " + demoPlayer.getDashStatus());
            Thread.sleep(500);
            //Crouch
            System.out.println(demoPlayer.getName() + "'s Current Crouch Status: " + demoPlayer.getCrouchStatus());
            Thread.sleep(2500);

            System.out.println(demoPlayer.getCords());
            do {
                System.out.print("\n");
                toString(trapsList, worldList, demoPlayer);
                input = askInput();
                action(demoPlayer, input);
                gameIsWon = demoPlayer.winCheck(lastFrameX);
            } while ((input.equalsIgnoreCase("w") ||
                    input.equalsIgnoreCase("a") ||
                    input.equalsIgnoreCase("s") ||
                    input.equalsIgnoreCase("d") ||
                    input.equalsIgnoreCase("p"))&&
                    !gameIsWon);

        } while (true);
    }
}
