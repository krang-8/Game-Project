package Model;
/*
* This class creates the scene and deal with the
* players inputs as well as the walls in the game
* contains a player object
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Player player;

    ArrayList<Wall> walls = new ArrayList<>();

    Timer gameTimer;

    public GamePanel(){

        player = new Player(400,300, this);

        reset();

        gameTimer = new Timer();
        gameTimer.schedule (new TimerTask(){

            @Override
            public void run() {
                player.set();
                repaint();
            }

        }, 0,17);

    }
/*
* Reset the player when they leave the screen
* or fall through the floor
* Initialize their location and speed
*/
    public void reset(){
        player.x = 200;
        player.y = 150;
        player.xSpeed = 0;
        player.ySpeed = 0;
        walls.clear();
        int offset = 50;
        makeWalls(offset);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
/*
* These methods are used to control the players movement
* based on the input from the keyboard and changes the boolean to true
* when the key is pressed
*/
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') player.keyLeft = true;
        if (e.getKeyChar() == 'd') player.keyRight = true;
        if (e.getKeyChar() == 'w') player.keyUp = true;
        if (e.getKeyChar() == 's') player.keyDown = true;
        if (e.getKeyChar() == 'p') player.keyDash = true;
    }
    /*
     * These methods are used to control the players movement
     * based on the input from the keyboard and changes the boolean to false
     * when the key is not being pressed
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') player.keyLeft = false;
        if (e.getKeyChar() == 'd') player.keyRight = false;
        if (e.getKeyChar() == 'w') player.keyUp = false;
        if (e.getKeyChar() == 's') player.keyDown = false;
        if (e.getKeyChar() == 'p') player.keyDash = false;
    }
    /*
     * This method gives the blocks location on the map
     * and creates the landscape of the map shown while
     * playing the game
     */

    public void makeWalls(int offset){
        for (int i = 0; i < 500; i+=25){
            walls.add(new Wall(i, 700, 25, 25));
        }
        for (int i = 575; i >= 575 && i < 1400; i+=25){
            walls.add(new Wall(i, 700, 25, 25));
        }
        walls.add(new Wall(100,600,25,25));
        walls.add(new Wall(125,600,25,25));
        walls.add(new Wall(150,600,25,25));
        walls.add(new Wall(175,600,25,25));
        walls.add(new Wall(200,600,25,25));

        walls.add(new Wall(400,675,25,25));

        walls.add(new Wall(425,650,25,25));
        walls.add(new Wall(425,675,25,25));

        walls.add(new Wall(450,625,25,25));
        walls.add(new Wall(450,650,25,25));
        walls.add(new Wall(450,675,25,25));

        walls.add(new Wall(475,675,25,25));
        walls.add(new Wall(475,650,25,25));
        walls.add(new Wall(475,625,25,25));
        walls.add(new Wall(475,600,25,25));


        walls.add(new Wall(575,675,25,25));
        walls.add(new Wall(575,650,25,25));
        walls.add(new Wall(575,625,25,25));
        walls.add(new Wall(575,600,25,25));

        walls.add(new Wall(600,625,25,25));
        walls.add(new Wall(600,650,25,25));
        walls.add(new Wall(600,675,25,25));

        walls.add(new Wall(625,650,25,25));
        walls.add(new Wall(625,675,25,25));

        walls.add(new Wall(650,675,25,25));


    }
    /*
    * This method paints the blocks
    */

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for (Wall Wall: walls) Wall.draw(gtd);

    }
}