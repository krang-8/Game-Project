import java.util.Scanner;

public class MainMenu {

    private static String gameName = "Demo1";

    // Play, Settings, Quit

    private static int introScreen() {
        // Ran in the run() method
        // Will introduce the user to the game and prompt to start the game

        String printIntro = ("Welcome to " +gameName + "\n" + "(1) Start Game" + "\n" + "(2) Settings " + "\n" + "(3) Quit");
        System.out.println(printIntro);
        System.out.println("Choose a option for the game!");
        Scanner introInputScanner = new Scanner(System.in);
        int introInput = introInputScanner.nextInt();

        while (introInput != 1 && introInput != 2 && introInput != 3) {
            System.out.println("Invalid option, please choose again");
            introInput = introInputScanner.nextInt();

        }
        return introInput;
    }
    // Method

    private static void startGame(){
        // If this is selected proceed to the game
    }

    private static void settings(){
        // If this is selected user will be able to modify the settings of the game
        System.out.println("No Settings available yet... Program terminating... See you soon!");
        System.exit(0);
    }

    private static void quit(){
        // If this is selected the game will exit
        System.out.println("See you soon...");
        System.exit(0);
    }
    private static void userSelection(int option){
        // Takes in an option during the user selection method to determine what the player wants to do
        if(option == 1){
            startGame();
        }
        if(option == 2){
            settings();
        }
        if(option == 3){
            quit();
        }
    }


    public void run() {
        //Runs the user selection screen and gets their input
        this.userSelection(introScreen());
    }
}
