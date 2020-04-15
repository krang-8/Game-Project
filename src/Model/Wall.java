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

        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);

        hitBox = new Rectangle(x,y,width,height);
    }

    public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Rectangle getHitBox() {
		return hitBox;
	}
	public void setX(int inputX) {
		if (inputX < 0) {
			this.x = x; 
		}
		else {
			x = inputX; 
		}
	}

	public void setY(int inputY) {
		if (inputY < 0) {
			this.y = y; 
		}
		else {
			y = inputY; 
		}
	}

	public void setWidth(int aWidth) {
		if (aWidth < 0) {
			this.width = width; 
		}
		else {
			width = aWidth; 
		}
	}

	public void setHeight(int aHeight) {
		if (aHeight < 0) {
			this.height = height; 
		}
		else {
			height = aHeight;
		}
	}

	public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.drawRect(x,y,width,height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x+1,y+1,width-2 ,height-2);
    }
}
