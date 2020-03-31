package Model;
/**
 * This class is used to help define what the map is
 * made of and sets the block up individually
 * and also draws the blocks onto the screen
 */

import java.awt.*;

public class Wall {
    int x;
    int y;
    int width;
    int height;

    Rectangle hitBox;

    public Wall(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.drawRect(x,y,width,height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x+1,y+1,width-2 ,height-2);
    }
}
