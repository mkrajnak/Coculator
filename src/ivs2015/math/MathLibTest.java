 /********************************************************************
 * Project: Simple calculator - C0CULATOR® 
 * Package: ivs2015.math
 * File: MathLibTest.java
 * Date: 22.4.2016
 * Authors: David Prexta (xprext00)
 * 			Maros Cocula (xcocul00)
 * 			Patrik Segedy (xseged00)
 * 			Martin Krajnak (xkrajn02)
 * Description: Class for testing mathematical library  				 
 *				Class is using JUnit Framework
 *******************************************************************/
/**
 * @file MathLibTest.java
 * @package ivs2015.math
 * @author David Prexta (xprext00)
 * @author Maros Cocula (xcocul00)
 * @author Patrik Segedy (xseged00)
 * @author Martin Krajnak (xkrajn02)
 * @version 9.9 (Zidan®)
 */
package ivs2015.math;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Main class which provides test methods
 * @brief provides test methods for mathematical functions
 * @see MathLib
 */
public class MathLibTest {
	
	MathLib math = new MathLib();
	
	/**
	 * @brief Testing sum
	 */
	@Test
	public void testAdd() {
		int iNumber = 8;
		double dNumber = 9.1;
		float fNumber = 10;
		
		assertEquals("Test int + int", 16, math.add(iNumber, iNumber));
		assertEquals("Test double + double", 18.2, math.add(dNumber, dNumber), 0.000001);
		assertEquals("Test float + float", 20.0, math.add(fNumber, fNumber), 0.000001);
		assertEquals("Test int + double", 17.1, math.add(iNumber, dNumber), 0.000001);
		assertEquals("Test int + float", 18.0, math.add(iNumber, fNumber), 0.000001);
		assertEquals("Test double + float", 19.1, math.add(dNumber, fNumber), 0.000001);
	}
	/**
	 * @brief Testing subtraction
	 */
	@Test
	public void testSub() {
		int iNumber1 = 8, iNumber2 = 10;
		double dNumber1 = 9.1, dNumber2 = 12.2;
		float fNumber1 = 10, fNumber2 = 14;
		
		assertEquals("Test int - int, positive", 2, math.sub(iNumber2, iNumber1));
		assertEquals("Test int - int, negative", -2, math.sub(iNumber1, iNumber2));
		assertEquals("Test double - double, positive", 3.1, math.sub(dNumber2, dNumber1), 0.000001);
		assertEquals("Test double - double, negative", -3.1, math.sub(dNumber1, dNumber2), 0.000001);
		assertEquals("Test double - double, zero", 0.0, math.sub(dNumber2, dNumber2), 0.000001);
		assertEquals("Test float - float, positive", 4.0, math.sub(fNumber2, fNumber1), 0.000001);
		assertEquals("Test float - float, positive", -4.0, math.sub(fNumber1, fNumber2), 0.000001);
		assertEquals("Test int - double, positive", 0.9, math.sub(iNumber2, dNumber1), 0.000001);
		assertEquals("Test int - double, negative", -2.2, math.sub(iNumber2, dNumber2), 0.000001);
		assertEquals("Test double - int", 2.2, math.sub(dNumber2, iNumber2), 0.000001);
		assertEquals("Test int - float", -2.0, math.sub(iNumber1, fNumber1), 0.000001);
		assertEquals("Test double - float", 2.2, math.sub(dNumber2, fNumber1), 0.000001);
	}
	/**
	 * @brief Testing multiplication
	 */
	@Test
	public void testMul() {
		int iNumber = 8;
		int iZero = 0;
		float fNumber = -9;
		double dNumber = 11.33;
		
		assertEquals("Test int * int", 64, math.mul(iNumber, iNumber));
		assertEquals("Test double * double", 128.3689, math.mul(dNumber, dNumber), 0.000001);
		assertEquals("Test float * float", 81.0, math.mul(fNumber, fNumber), 0.000001);
		assertEquals("Test int * double", 90.64, math.mul(iNumber, dNumber), 0.000001);
		assertEquals("Test int * float", -72.0, math.mul(iNumber, fNumber), 0.000001);
		assertEquals("Test double * float", -101.97, math.mul(dNumber, fNumber), 0.000001);
		assertEquals("Test float * int zero", 0, math.mul(fNumber, iZero), 0.000001);
	}
	/**
	 * @brief Testing division
	 */
	@Test
	public void testDiv() {
		int iNumber = 8;
		int iZero = 0;
		float fNumber = -9;
		double dNumber = 11.33;
		
		assertEquals("Test int / int", 1, math.div(iNumber, iNumber), 0.0001);
        assertEquals("Test double / double", 1.0, math.div(dNumber, dNumber), 0.000001);
        assertEquals("Test float / float", 1.0, math.div(fNumber, fNumber), 0.000001);
        assertEquals("Test int / double", 0.706090026478, math.div(iNumber, dNumber), 0.00000000001);
        assertEquals("Test int / float", -0.888888, math.div(iNumber, fNumber), 0.00001);
        assertEquals("Test double / float", -1.25888, math.div(dNumber, fNumber), 0.00001);
        
        assertEquals("Test float / int zero", Double.NaN, math.div(fNumber, iZero), 0.000001);
        assertEquals("Test int zero / float", 0.0, math.div(iZero, fNumber), 0.000001);
        assertEquals("Test +inf / double", Double.POSITIVE_INFINITY, math.div(Double.POSITIVE_INFINITY, dNumber), 0.000001);
	}
	/**
	 * @brief Testing square root
	 */
	@Test
	public void testSqrt() {
		assertEquals("Test sqrt(0)", 0, math.sqrt(0), 0.0001);
		assertEquals("Test sqrt(4)", 2, math.sqrt(4), 0.0001);
		assertEquals("Test sqrt(40000", 200, math.sqrt(40000), 0.0001);
		assertEquals("Test sqrt(-4)", Double.NaN, math.sqrt(-4), 0.0001);
		assertEquals("Test Double.POSITIVE_INFINITY", Double.POSITIVE_INFINITY, math.sqrt(Double.POSITIVE_INFINITY), 0.0001);
		assertEquals("Test Double.NEGATIVE_INFINITY", Double.NaN, math.sqrt(Double.NEGATIVE_INFINITY), 0.0001);
	}
	/**
	 * @brief Testing factorial
	 */
	@Test
	public void testFact() {
		assertEquals("Test na zaporne cislo", -5, math.fact(-3));
		assertEquals("Test 0!", 1, math.fact(0));
		assertEquals("Test 1!", 1, math.fact(1));
		assertEquals("Test 2!", 2, math.fact(2));
		assertEquals("Test 3!", 6, math.fact(3));
		assertEquals("Test 4!", 24, math.fact(4));
		assertEquals("Test 5!", 120, math.fact(5));
	}
	/**
	 * @brief Testing power
	 */
	@Test
	public void testPow() {
		assertEquals("Test 0^5", 0, math.pow(0,5), 0.0001);
		assertEquals("Test 2^0", 1, math.pow(2,0), 0.0001);
		assertEquals("Test 2^2", 4, math.pow(2,2), 0.0001);
		assertEquals("Test 2^10", 1024, math.pow(2,10), 0.0001);
		assertEquals("Test 2^-5", 0.03125, math.pow(2,-5), 0.0001);
		assertEquals("Test 2^5", 32, math.pow(2,5), 0.0001);
		
	}

}
/*** End of file MathLibTest.java ***/