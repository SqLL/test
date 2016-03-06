package tutorial.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.*;


/**
 * Unit test for simple App.
 */

public class AppTest {
	
	// Basic Test
	
	@Test
	public void additionTest() {
		int resultAttendu = 5;
		int resultatObtenu = App.addition(2, 3);
		assertEquals(resultAttendu, resultatObtenu);
	}
	
	@Test
	public void additionTestRange() {
		int resultAttendu = 2147483647;
		int resultatObtenu = App.addition(2147483647, 3);
		assertNotSame("Out of limit" ,resultAttendu, resultatObtenu);
	}
	
}
