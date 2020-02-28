/* import java.awt.Rectangle;

public class RectangleCollision {
	// instances (not sure if will be used yet)
	int xRectangle;
	int yRectangle;
	boolean collisionStatus = false;
	
	public Rectangle drawPlayerBounds() { // draw hitbox for Player
		Rectangle playerRectangle = new Rectangle(Character.getX, Character.getY, Character.getY + Character.HEIGHT,Character.getX + Character.WIDTH);
		return playerRectangle;
	}	
		
	public Rectangle drawBlockBounds() { // draw hitbox for Blocks
		Rectangle blockRectangle = new Rectangle(Blocks.getxLocationBlock(), Blocks.getyLocationBlock())
		
	}
	public void collision(){ // used to detect the collision between hitboxes
		if (playerRectangle.intersects(blockRectangle))
			collisionStatus = true
		while (collisionStatus){
			System.out.println("Oops, you are colliding with something!); 
		}
			
		
	}
	
	 
	
	
}
/*
