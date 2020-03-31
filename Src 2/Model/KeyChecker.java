package Model;
/**
 * These methods are called in game panel to detect the users input
 * from the keyboard
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyChecker implements KeyListener {

    GamePanel panel;

    public KeyChecker(GamePanel panel){
        this.panel = panel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    panel.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    panel.keyReleased(e);
    }
}