package ivs2015.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import static org.junit.Assert.*;

import ivs2015.coculator.*; 

public class Calculator_tests {
	
	@Test
	public void test1() throws AWTException, InterruptedException {
		// x=	80 , 180 , 280,  380
		// y= 	110 ,150 , 190 , 230 ,270
		System.out.println("Test1");
		Coculator calc = new Coculator();
		TimeUnit.SECONDS.sleep(1);
		Robot bot = new Robot();
		bot.mouseMove(80,190);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.SECONDS.sleep(1);
		bot.mouseMove(380,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.SECONDS.sleep(1);
		bot.mouseMove(80,110);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.SECONDS.sleep(1);
		bot.mouseMove(280,230);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		TimeUnit.SECONDS.sleep(1);
		
		String value = calc.getDisplayResult();
		double val = Double.parseDouble(value);
		System.out.println(val);
		assertEquals("Test 1+7=8", 8.0, val, 0.001);

		
	}
	
	

}
