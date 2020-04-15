package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	
	/**
	 * Test methods for Constructor (Positive values)
	 */
	
	@Test
	public void test_Constructor() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(50, 42, p1);
        
        assertEquals("Testing for X-value:", 50, a.getX());
        assertEquals("Testing for Y-value:", 42, a.getY());
        assertEquals("Testing for Panel reset X-value:", 200, p1.player.getX());
        assertEquals("Testing for Panel reset Y-value:", 150, p1.player.getY());
        assertNotNull("Testing for a non-null GamePanel:", a.getPanel());
        assertNotNull("Testing for a non-null Hit Box", a.getHitBox());
	}
	
	/**
	 * Test methods for Constructor (Negative Y)
	 */
	
	@Test
	public void test_Constructor_NegativeY() {
		GamePanel p1 = new GamePanel();
        Player b = new Player(40, -30, p1);
        
        assertEquals("Testing for X-value:", 40, b.getX());
        assertEquals("Testing for Y-value:", 150, b.getY());
        assertNotNull("Testing for a non-null GamePanel:", b.getPanel());
        assertNotNull("Testing for a non-null Hit Box", b.getHitBox());
	}

	/**
	 * Test method for X getter 
	 */
	
	@Test
	public void test_getX() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        int actual = a.getX();
        int actualP = p1.player.getX();
        
        assertEquals("Testing for X-value", 2, actual);
        assertEquals("Testing for Panel reset X-value", 200, actualP);
	}

	/**
	 * Test method for X setter
	 */
	
	@Test
	public void test_setX() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        a.setX(52);
        
        int actual = a.getX();
        int actualP = p1.player.getX();
        
        assertEquals("Testing for set X-value", 52, actual);
        assertEquals("Testing for Panel reset X-value", 200, actualP);
	}
	
	/**
	 * Test method for Y getter
	 */
	
	@Test
	public void test_getY() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(40, 30, p1);

        int actual = a.getY();
        int actualP = p1.player.getY();
        
        assertEquals("Testing for Y-value", 30, actual);
        assertEquals("Testing for Panel reset Y-value", 150, actualP);
	}
	
	/**
	 * Test method for Y getter (Negative value)
	 */
	
	@Test
	public void test_getY_Negative() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(40, -30, p1);

        int actual = a.getY();
        
        assertEquals("Testing for Y-value", 150, actual);
	}
	
	/**
	 * Test method for Y setter 
	 */
	
	@Test
	public void test_setY() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(40, 22, p1);
        a.setY(20);

        int actual = a.getY();
        
        assertEquals("Testing for set Y-value", 20, actual);
	}

	/**
	 * Test method for Y setter (Negative value)
	 */
	
	@Test
	public void test_setY_Negative() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(40, 22, p1);
        a.setY(-20);

        int actual = a.getY();
        
        assertEquals("Testing for set Y-value", 150, actual);
	}
	
	/**
	 * Test method for Panel getter 
	 */
	
	@Test
	public void test_getPanel() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        assertNotNull("Testing for a non-null GamePanel:", a.getPanel());
	}

	/**
	 * Test method for HitBox getter 
	 */
	
	@Test
	public void test_getHitBox() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(2, 31, p1);
        
        assertNotNull("Testing for a non-null Hit Box", a.getHitBox());
	}

	/**
	 * Test method for Width getter (Default value)
	 */
	
	@Test
	public void test_getWidth_Default() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(17, 24, p1);
        
        int actual = a.getWidth();
        
        assertEquals("Testing for default Width", 50, actual);
	}

	/**
	 * Test method for Height getter (Default value)
	 */
	
	@Test
	public void test_getHeight_Default() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(45, 4, p1);
        
        int actual = a.getHeight();
        
        assertEquals("Testing for default Height", 100, actual);
	}

	/**
	 * Test method for xSpeed getter (Default value)
	 */
	
	@Test
	public void test_getxSpeed_Default() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(72, 100, p1);
        
        double actual = a.getxSpeed();
        
        assertEquals("Testing for default xSpeed", 0.0, actual, 0.000000001);
	}
	
	/**
	 * Test method for xSpeed getter (Movement value)
	 */
	
	@Test
	public void test_getxSpeed_Movement() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(72, 100, p1);
        a.set();
        
        double actual = a.getxSpeed();
        
        assertEquals("Testing for xSpeed", 0.0, actual, 0.000000001);
	}
	
	/**
	 * Test method for ySpeed getter (Default value)
	 */
	
	@Test
	public void test_getySpeed_Default() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(49, 81, p1);
        
        double actual = a.getySpeed();
        
        assertEquals("Testing for default ySpeed", 0.0, actual, 0.000000001);
	}

	/**
	 * Test method for ySpeed getter (Movement value)
	 */
	
	@Test
	public void test_getySpeed_Movement() {
		GamePanel p1 = new GamePanel();
        Player a = new Player(49, 81, p1);
        a.set();
        
        double actual = a.getySpeed();
        
        assertEquals("Testing for ySpeed", 0.3, actual, 0.000000001);
	}
	
	/**
	 * Test method for set() 
	 */
	
	@Test
	public void test_set() {
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
