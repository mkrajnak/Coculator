 /*****************************************************************
 * Project: Simple calculator - C0CULATOR® 
 * Package: ivs2015.tests
 * File: Calculator_tests.java
 * Date: 22.4.2016
 * Authors: David Prexta (xprext00)
 * 			Maros Cocula (xcocul00)
 * 			Patrik Segedy (xseged00)
 * 			Martin krajnak (xkrajn02)
 * Description: Class is providing basic tests of user interface and basic mathematical functions  				 	
 ******************************************************************/
/**
 * @file Calculator_tests.java
 * @package ivs2015.tests
 * @author David Prexta (xprext00)
 * @author Maros Cocula (xcocul00)
 * @author Patrik Segedy (xseged00)
 * @author Martin Krajnak (xkrajn02)
 * @version 9.9 (Zidan®)
 */
package ivs2015.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import static org.junit.Assert.*;

import ivs2015.coculator.*; 

/**
 * Class contains test of user interface and basic functions
 * @class Calculator_tests
 * @brief provides test methods for UI
 * @see ivs2015.coculator.Coculator
 */

public class Calculator_tests {
	
		public Coculator calc = new Coculator(0, 0);
		public Robot bot;
		public String value;
		double val;
		/* x/y | 80 , 180 , 280,  380
		 * ____|________________________
		 * 110 |  7	   8 	 9	   /	 
		 * 150 |  4    5	 6 	   *
		 * 190 |  1	   2	 3	   -
		 * 230 |  0	   C	 =	   +
		 * 270 |  .	   !	 e^	  sqrt
		 */

	/**
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	@Test
	public void test_plus_gui() throws AWTException, InterruptedException {

		//System.out.println("Test 1+7=[8]");
		TimeUnit.SECONDS.sleep(1);
		bot = new Robot();
		bot.mouseMove(80,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(380,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,110);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 1+7=8", 8, val, 0.001);
		
		//System.out.println("Test 1+7=8+5=[13]");
		bot.mouseMove(380,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 1+7=8+5=13", 13, val, 0.001);
		

		//System.out.println("Test 1+7+5+2,5=[15,5]");
		bot.mouseMove(380,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,270);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);

		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 1+7+5+2.5=15,5", 15.5, val, 0.001);
		
	}
	/**
	 * @brief Test of subtraction
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	@Test
	public void test_minus_gui() throws AWTException, InterruptedException {
		
		//System.out.println("Test 1-7=[-6]");
		TimeUnit.SECONDS.sleep(1);
		bot = new Robot();
		bot.mouseMove(80,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(380,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,110);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 1-7=-6", -6, val, 0.001);
		
		//System.out.println("Test 1-7=-6+9=[3]");
		bot.mouseMove(380,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,110);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 1-7+9=3", 3, val, 0.001);
		
		//System.out.println("Test 1+7+5+2,5=[15,5]");
		bot.mouseMove(380,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,270);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);

		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 1-7+9-2.5=0.5", 0.5, val, 0.001);
		
	}
	/**
	 * @brief Testing multiplication
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	@Test
	public void test_multiplication_gui() throws AWTException, InterruptedException {
		
		//System.out.println("Test 2*7=[14]"); 
		TimeUnit.SECONDS.sleep(1);
		bot = new Robot();
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(380,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,110);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 2*7=14", 14, val, 0.001);
		

		//System.out.println("Test 2*7**2,2=[30,8]");
		bot.mouseMove(380,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(380,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,270);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);

		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 2*7**2,2=30,8", 30.8, val, 0.001);
		
	}
	/**
	 * @brief Function is testing clear function
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	@Test
	public void test_clear_gui() throws AWTException, InterruptedException {
		
		TimeUnit.SECONDS.sleep(1);
		bot = new Robot();
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(180,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		
		value = calc.getDisplayResult();
		assertEquals("Test clear", "", value);
	}
	/**
	 * @brief Function is testing two operations in a row  
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	@Test
	public void test_two_operations() throws AWTException, InterruptedException {

		TimeUnit.SECONDS.sleep(1);
		bot = new Robot();
		bot.mouseMove(180,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(380,150);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(380,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(80,110);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.MILLISECONDS.sleep(100);
		
		value = calc.getDisplayResult();
		val = Double.parseDouble(value);
		assertEquals("Test 2*+7=9", 9, val, 0.001);
	
	}

}

/*** End of file Calculator_tests.java ***/