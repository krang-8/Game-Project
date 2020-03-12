package View;
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

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') player.keyLeft = true;
        if (e.getKeyChar() == 'd') player.keyRight = true;
        if (e.getKeyChar() == 'w') player.keyUp = true;
        if (e.getKeyChar() == 's') player.keyDown = true;
        if (e.getKeyChar() == 'p') player.keyDash = true;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') player.keyLeft = false;
        if (e.getKeyChar() == 'd') player.keyRight = false;
        if (e.getKeyChar() == 'w') player.keyUp = false;
        if (e.getKeyChar() == 's') player.keyDown = false;
        if (e.getKeyChar() == 'p') player.keyDash = false;
    }

    public void makeWalls(int offset){
        for (int i = 0; i<1400; i+=25){
            walls.add(new Wall(i, 700, 25, 25));
        }
        walls.add(new Wall(150,600,25,25));
        walls.add(new Wall(175,600,25,25));
        walls.add(new Wall(200,600,25,25));
        walls.add(new Wall(225,600,25,25));
        walls.add(new Wall(250,600,25,25));

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

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for (Wall Wall: walls) Wall.draw(gtd);

    }
}