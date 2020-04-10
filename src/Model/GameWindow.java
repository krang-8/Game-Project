package Model;
/**
 * Makes and sets up the game window
 * sets the location and the color
 */

import java.awt.*;

public class GameWindow extends javax.swing.JFrame {


    public GameWindow() {
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.getSize(this.getSize());


        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener((new KeyChecker(panel)));
    }

}
