import java.util.Scanner;

public class mainMenu {

    private static String gameName = "Untitled";

    // Play, Settings, Quit

    public static int introScreen() {
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

    public static void startGame(){
        // If this is selected proceed to the game
    }

    public static void settings(){
        // If this is selected user will be able to modify the settings of the game
        System.out.println("No Settings available yet... Program terminating... See you soon!");
        System.exit(0);
    }

    public static void quit(){
        // If this is selected the game will exit
        System.out.println("See you soon...");
        System.exit(0);
    }
    public static void userSelection(int option){
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



}
