/**
 * 
 */
package Model;

import static org.junit.Assert.*;

import org.junit.Test;


public class WallTest {

	/**
	 * Test methods for Constructor (Positive values){@link Model.Wall#Wall(int, int, int, int)}.
	 */
	@Test
	public void test_Constructor() {
		Wall a = new Wall(2, 4, 20, 50);
		
		assertEquals("Testing for X-value", 2, a.getX());
		assertEquals("Testing for Y-value", 4, a.getY());
		assertEquals("Testing for Width", 20, a.getWidth());
		assertEquals("Testing for Height", 50, a.getHeight());
		assertNotNull("Testing for non-null hitBox", a.getHitBox());
	}
	
	/**
	 * Test methods for Constructor (Negative values){@link Model.Wall#Wall(int, int, int, int)}.
	 */
	
	@Test
	public void test_Constructor_Negative() {
		Wall a = new Wall(-2, -4, -20, -50);
		
		assertEquals("Testing for X-value", 0, a.getX());
		assertEquals("Testing for Y-value", 0, a.getY());
		assertEquals("Testing for Width", 0, a.getWidth());
		assertEquals("Testing for Height", 0, a.getHeight());
		assertNotNull("Testing for non-null hitBox", a.getHitBox());
	}

	/**
	 * Test method for X getter {@link Model.Wall#getX()}.
	 */
	@Test
	public void test_getX() {
		Wall a = new Wall(9, 4, 20, 50);
		
		int actual = a.getX();
		
		assertEquals("Testing for X-value", 9, actual);
	}

	/**
	 * Test method for Y getter {@link Model.Wall#getY()}.
	 */
	@Test
	public void test_getY() {
		Wall a = new Wall(2, 6, 20, 50);
		
		int actual = a.getY();
		
		assertEquals("Testing for Y-value", 6, actual);
	}

	/**
	 * Test method for Width getter {@link Model.Wall#getWidth()}.
	 */
	@Test
	public void test_getWidth() {
		Wall a = new Wall(1, 6, 25, 50);
		
		int actual = a.getWidth();
		
		assertEquals("Testing for Width", 25, actual);
	}

	/**
	 * Test method for Height getter {@link Model.Wall#getHeight()}.
	 */
	@Test
	public void test_getHeight() {
		Wall a = new Wall(2, 6, 20, 52);
		
		int actual = a.getHeight();
		
		assertEquals("Testing for Height", 52, actual);
	}

	/**
	 * Test method for hitBox getter {@link Model.Wall#getHitBox()}.
	 */
	@Test
	public void test_getHitBox() {
		Wall a = new Wall(2, 6, 20, 50);
		
		assertNotNull("Testing for non-null hitBox", a.getHitBox());
	}

	/**
	 * Test method for X setter {@link Model.Wall#setX(int)}.
	 */
	@Test
	public void test_setX() {
		Wall a = new Wall(1, 6, 25, 50);
		a.setX(40);
		
		int actual = a.getX();
		
		assertEquals("Testing for set X-value", 40, actual);
	}

	/**
	 * Test method for X setter - Negative value {@link Model.Wall#setY(int)}.
	 */
	
	@Test
	public void test_setX_Negative() {
		Wall a = new Wall(1, 6, 25, 50);
		a.setX(-100);
		
		int actual = a.getX();
		
		assertEquals("Testing for set X-value", 1, actual);
	}
	
	/**
	 * Test method for Y setter {@link Model.Wall#setY(int)}.
	 */
	
	@Test
	public void test_setY() {
		Wall a = new Wall(1, 8, 25, 50);
		a.setY(62);
		
		int actual = a.getY();
		
		assertEquals("Testing for set Y-value", 62, actual);
	}
	
	/**
	 * Test method for Y setter - Negative value {@link Model.Wall#setY(int)}.
	 */

	@Test
	public void test_setY_Negative() {
		Wall a = new Wall(1, 6, 25, 50);
		a.setY(-29);
		
		int actual = a.getY();
		
		assertEquals("Testing for set Y-value", 6, actual);
	}
	
	/**
	 * Test method for Width setter {@link Model.Wall#setWidth(int)}.
	 */
	@Test
	public void test_setWidth() {
		Wall a = new Wall(1, 6, 25, 50);
		a.setWidth(32);
		
		int actual = a.getWidth();
		
		assertEquals("Testing for set Width", 32, actual);
	}

	/**
	 * Test method for Width setter - negative value {@link Model.Wall#setWidth(int)}.
	 */
	
	@Test
	public void test_setWidth_Negative() {
		Wall a = new Wall(1, 6, 49, 50);
		a.setWidth(-24);
		
		int actual = a.getWidth();
		
		assertEquals("Testing for set Width", 49, actual);
	}
	
	/**
	 * Test method for Height setter {@link Model.Wall#setHeight(int)}.
	 */
	@Test
	public void test_setHeight() {
		Wall a = new Wall(1, 6, 25, 50);
		a.setHeight(100);
		
		int actual = a.getHeight();
		
		assertEquals("Testing for set Height", 100, actual);
	}

	/**
	 * Test method for Height setter - Negative value {@link Model.Wall#setHeight(int)}.
	 */
	
	@Test
	public void test_setHeight_Negative() {
		Wall a = new Wall(1, 6, 25, 91);
		a.setHeight(-80);
		
		int actual = a.getHeight();
		
		assertEquals("Testing for set Height", 91, actual);
	}

}
