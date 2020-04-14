package Model;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(50, 42, p1);
        
        int actualX = a.getX();
        int actualY = a.getY();

        assertEquals("Testing for X-value:", 50, actualX);
        assertEquals("Testing for Y-value:", 42, actualY);
        assertEquals("Testing for Panel reset X-value:", 200, p1.player.getX());
        assertEquals("Testing for Panel reset Y-value:", 150, p1.player.getY());
        assertNotNull("Testing for a non-null GamePanel:", a.getPanel());
        assertNotNull("Testing for a non-null Hit Box", a.getHitBox());
	}

	@Test
	public void testGetX() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        Player b = new Player(40, 31, p1);
        b.setX(6);
        
        int actual = a.getX();
        int actualP = p1.player.getX();
        
        assertEquals("Testing for X-value", 2, actual);
        assertEquals("Testing for Panel reset X-value", 200, actualP);
        assertEquals("Testing for set X-value", 6, b.getX());
	}

	@Test
	public void testGetY() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 17, p1);
        
        int actual = a.getY();
        int actualP = p1.player.getY();
        
        assertEquals("Testing for Y-value", 17, actual);
        assertEquals("Testing for Panel reset Y-value", 150, actualP);
	}

	@Test
	public void testGetPanel() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        assertNotNull("Testing for a non-null GamePanel:", a.getPanel());
	}

	@Test
	public void testGetHitBox() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        assertNotNull("Testing for a non-null Hit Box", a.getHitBox());
	}

	@Test
	public void testGetWidth() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        int actual = a.getWidth();
        
        assertEquals("Testing for default Width", 50, actual);
	}

	@Test
	public void testGetHeight() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        int actual = a.getHeight();
        
        assertEquals("Testing for default Height", 100, actual);
	}

	@Test
	public void testGetxSpeed() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        double actual = a.getxSpeed();
        
        assertEquals("Testing for default xSpeed", 0.0, actual, 0.000000001);
	}

	@Test
	public void testGetySpeed() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        double actual = p1.player.getySpeed();
        
        assertEquals("Testing for default ySpeed", 0.0, actual, 0.000000001);
	}

	@Test
	public void testIsKeyLeft() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
	}

	@Test
	public void testIsKeyRight() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
	}

	@Test
	public void testIsKeyUp() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
	}

	@Test
	public void testIsKeyDown() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
	}

	@Test
	public void testIsKeyDash() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
	}

	@Test
	public void testSet() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(800, 1000, p1);
        a.set();
        int actualX = p1.player.getX();
        int actualY = p1.player.getY();
        double actualXS = a.getxSpeed();
        double actualYS = a.getySpeed();
        
        assertEquals("Testing for set X-value", 200, actualX);
        assertEquals("Testing for set Y-value", 150, actualY);
        assertEquals("Testing for xSpeed", 0.0, actualXS, 0.000000001);
        assertEquals("Testing for ySpeed", 0.3, actualYS, 0.000000001);
	}


}
