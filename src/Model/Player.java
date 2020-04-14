package Model;
/**
 * This creates an Player object
 * and handles the physics of the player in
 * the game with regards to collisions with blocks
 * as well as drawing the player
 **/

import java.awt.*;

public class Player {

    GamePanel panel;

 /*
* Instance variables
 */
    int x;
    int y;
    int width = 50;
    int height = 100;

    double xSpeed;
    double ySpeed;

    Rectangle hitBox;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;
    boolean keyDash;

    public Player(int x, int y, GamePanel panel) {
        this.panel = panel;
        setX(x);
        setY(y);
        hitBox = new Rectangle(x, y, width, height);
    }
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    public void setX(int input) {
		x = input;
	}
	public void setY(int input) {
		if (input < 0) {
			y = 150;
		}
		else {
			y = input;
		}
	}
	public GamePanel getPanel() {
    	return panel;
    }
    public Rectangle getHitBox() {
    	return hitBox;
    }
    public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public double getxSpeed() {
		return xSpeed;
	}
	public double getySpeed() {
		return ySpeed;
	}
	
	// This handles the physics of the game using the players inputs and also handles the hitbox
    public void set() {
        if (keyLeft && keyRight || !keyLeft && !keyRight) xSpeed *= 0.8;
        else if (keyLeft && !keyRight) xSpeed--;
        else if (keyRight && !keyLeft) xSpeed++;

        if (xSpeed > 0 && xSpeed < 0.75) xSpeed = 0;
        if (xSpeed < 0 && xSpeed > -0.75) xSpeed = 0;

        if (xSpeed > 5) xSpeed = 5;
        if (xSpeed < -5) xSpeed = -5;

        if (keyUp) {
            // Check if touching the ground
            hitBox.y++;
            for (Wall wall : panel.walls) {
                if (wall.hitBox.intersects(hitBox)) ySpeed = -6;
            }
        }

        if (keyDash) {
            if (keyUp)
                xSpeed *= 2.0;
            if (!keyUp)
                xSpeed *= 1.5;

        }
            else xSpeed = xSpeed;



        ySpeed += 0.3;

        // Horizontal Collisions
        hitBox.x += xSpeed;
        for (Wall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.x -= xSpeed;
                while (!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xSpeed);
                hitBox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitBox.x;
            }
        }
        // Vertical Collisions
        hitBox.y += ySpeed;
        for (Wall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.y -= ySpeed;
                while (!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(ySpeed);
                hitBox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitBox.y;
            }
        }

        x += xSpeed;
        y += ySpeed;

        hitBox.x = x;
        hitBox.y = y;

        // Death Code
        if (y > 900) panel.reset();
    }

    // Drawing the object
    public void draw(Graphics2D gtd) {

            if (keyDown) {
                hitBox.setLocation(x, y);
                hitBox.setSize(width, height - 26);
                gtd.drawRect(x, y + 27, width, height / 2);
                gtd.setColor(Color.PINK);
                gtd.fillRect(x, y + 27, width, height / 2);
            }
            else {
                gtd.setColor(Color.BLUE);
                gtd.fillRect(x, y, width, height);
                hitBox.setBounds(x, y, width, height);

            }
        }
    }