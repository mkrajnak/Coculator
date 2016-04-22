package ivs2015.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import static org.junit.Assert.*;

import ivs2015.coculator.*; 

public class Calculator_tests {
	
		public Coculator calc = new Coculator();
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

