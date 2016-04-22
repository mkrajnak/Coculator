 /********************************************************************
 * Project: Simple calculator - C0CULATOR® 
 * Package: ivs2015.math
 * File: MathLib.java
 * Date: 22.4.2016
 * Authors: David Prexta (xprext00)
 * 			Maros Cocula (xcocul00)
 * 			Patrik Segedy (xseged00)
 * 			Martin krajnak (xkrajn02)
 * Description: Class provides functions for mathematical calculations  				 
 *******************************************************************/
/**
 * @file MathLib.java
 * @package ivs2015.math
 * @brief Class provides functions for mathematical calculations
 * @author David Prexta (xprext00)
 * @author Maros Cocula (xcocul00)
 * @author Patrik Segedy (xseged00)
 * @author Martin krajnak(xkrajn02)
 * @version 9.9
 */
package ivs2015.math;

public class MathLib {
	/**
	 * @brief Sum of two numbers (double)
	 * @param num1
	 * @param num2
	 * @return (double) sum
	 */
    public double add (double num1, double num2) {
        return num1 + num2;
    }
    
    /**
	 * @brief Sum of two numbers (float)
	 * @param num1
	 * @param num2
	 * @return (float) sum
	 */
    public float add (float num1, float num2) {
        return num1 + num2;
    }
    
    /**
	 * @brief Sum of two numbers (integer)
	 * @param num1
	 * @param num2
	 * @return (integer) sum
	 */
    public int add (int num1, int num2) {
        return num1 + num2;
    }
    
    /**
     * @brief Subtraction of two number (double)
     * @param num1
     * @param num2
     * @return (double) subtraction
     */
    public double sub (double num1, double num2) {
        return num1 - num2;
    }
    
    /**
     * @brief Subtraction of two number (float)
     * @param num1
     * @param num2
     * @return (float) subtraction
     */
    public float sub (float num1, float num2) {
        return num1 - num2;
    }
    
    /**
     * @brief Subtraction of two number (integer))
     * @param num1
     * @param num2
     * @return (integer) subtraction
     */
    public int sub (int num1, int num2) {
        return num1 - num2;
    }
    
    /**
     * @brief Multiplication of two number (double)
     * @param num1
     * @param num2
     * @return (double) multiplication
     */
    public double mul (double num1, double num2) {
        return num1 * num2;
    }
    
    /**
     * @brief Multiplication of two number (float)
     * @param num1
     * @param num2
     * @return (float) multiplication
     */
    public float mul (float num1, float num2) {
        return num1 * num2;
    }
    
    /**
     * @brief Multiplication of two number (integer)
     * @param num1
     * @param num2
     * @return (integer) multiplication
     */
    public int mul (int num1, int num2) {
        return num1 * num2;
    }
    
    /**
     * @brief Division of two number (double)
     * @param num1
     * @param num2
     * @return (double) division
     */
    public double div (double num1, double num2) {
        if (num2 == 0) {
        	return Double.NaN;
        }
        else {
            return num1/num2;
        }
    }
    
    /**
     * @brief Division of two number (float)
     * @param num1
     * @param num2
     * @return (float) division
     */
    public float div (float num1, float num2) {
        if (num2 == 0) {
        	return Float.NaN;
        }
        else {
            return num1/num2;
        }
    }
    
    /**
     * @brief Square root
     * @param num This is number which is calculated
     * @return Square root of number
     */
    public double sqrt (double num) {
    	if (Double.isNaN(num))
			return Double.NaN;
		else if (num == Double.POSITIVE_INFINITY)
			return Double.POSITIVE_INFINITY;
		else if (num == Double.NEGATIVE_INFINITY)
			return Double.NaN;
		else if (num < 0)
			return Double.NaN;
		else if (num == 0)
			return 0;
		else
			return java.lang.Math.sqrt(num);
    }
    
    /**
     * @brief Calculation of factorial
     * @param num This is number which is calculated
     * @return factorial of num
     */
    public long fact (int num) {
    	// paradny algoritmus z http://www.luschny.de/math/factorial/csharp/ScriptFactorial.html
    	double ex = 0.0;
    	double x = (double)num;
    	x = x + x + 1;
    	
    	if (x > 1) {
    		x = (Math.log(2.0 * Math.PI) + Math.log(x/2.0) * x - x - (1.0 - 7.0 / (30.0 * x * x)) / (6.0 * x)) / 2.0;
    		x = x / Math.log(10);
    		ex = Math.floor(x);
    		x = Math.pow(10, x - ex);
    	}
    	if (ex > 0)
    		return (long)(x*Math.pow(10,ex));
    	return (long)x;

    }
    
    /**
     * @brief Calculates base^exponent
     * @param base This represents base
     * @param exponent This represents exponent
     * @return base^exponent
     */
    public double pow (double base, double exponent) {
    	return java.lang.Math.pow(base, exponent);
    }
}
/*** end of file MathLib.java ***/