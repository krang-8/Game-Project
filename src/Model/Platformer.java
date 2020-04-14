package Model;
import javax.swing.*;
import java.awt.*;

/**
 * This executes the program and defines the boundaries of the
 * platformer and handles closing the game as well
 */

public class Platformer {

    public Platformer(){

        GameWindow frame = new GameWindow();
        

        frame.setSize(1300,800);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));

        frame.setResizable(true);
        frame.setTitle("Un-titled Game");
        frame.setVisible(true);
        System.out.println("IN PLATFORMER");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

    }
}
