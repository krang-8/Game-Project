import java.util.Scanner;

public class mainMenu {

    private static String gameName = "Untitled";
    private static String startGame = "Start Game";
    private static String settings = "Settings";
    private static String quit = "Quit";

    // Play, Settings, Quit

    public String introScreen() {
        String printIntro = ("(1) "+ gameName + "\n" + "(2) " + startGame + "\n" + "(3) " + settings);
        System.out.println(printIntro);
        System.out.println("Choose a option for the game!");
        Scanner introInputScanner = new Scanner(System.in);
        int introInput = introInputScanner.nextInt();

        while (introInput != 1 && introInput != 2 && introInput != 3) {
            System.out.println("Invalid option, please choose again");
            introInput = introInputScanner.nextInt();

        }
        return printIntro;
    }



}
