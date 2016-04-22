/**
 * @file MathLib.java
 * 
 */
package ivs2015.math;

/**
 * Matematicka kniznica pre druhy projekt do predmetu IVS
 * @author Patrik Segedy
 * @version 0.1
 */
public class MathLib {
	/**
	 * Sucet dvoch cisel (double)
	 * @param num1
	 * @param num2
	 * @return (double) sucet
	 */
    public double add (double num1, double num2) {
        return num1 + num2;
    }
    
    /**
     * Sucet dvoch cisel (float)
     * @param num1
     * @param num2
     * @return (float) sucet
     */
    public float add (float num1, float num2) {
        return num1 + num2;
    }
    
    /**
     * Sucet dvoch cisel (int)
     * @param num1
     * @param num2
     * @return (int) sucet
     */
    public int add (int num1, int num2) {
        return num1 + num2;
    }
    
    /**
     * Rozdiel dvoch cisel (double)
     * @param num1
     * @param num2
     * @return (double) rozdiel
     */
    public double sub (double num1, double num2) {
        return num1 - num2;
    }
    
    /**
     * Rozdiel dvoch cisel (float)
     * @param num1
     * @param num2
     * @return (float) rozdiel
     */
    public float sub (float num1, float num2) {
        return num1 - num2;
    }
    
    /**
     * Rozdiel dvoch cisel (int)
     * @param num1
     * @param num2
     * @return (int) rozdiel
     */
    public int sub (int num1, int num2) {
        return num1 - num2;
    }
    
    /**
     * Nasobenie dvoch cisel (double)
     * @param num1
     * @param num2
     * @return (double) sucin
     */
    public double mul (double num1, double num2) {
        return num1 * num2;
    }
    
    /**
     * Nasobenie dvoch cisel (float)
     * @param num1
     * @param num2
     * @return (float) sucin
     */
    public float mul (float num1, float num2) {
        return num1 * num2;
    }
    
    /**
     * Nasobenie dvoch cisel (int)
     * @param num1
     * @param num2
     * @return (int) sucin
     */
    public int mul (int num1, int num2) {
        return num1 * num2;
    }
    
    /**
     * Delenie dvoch cisel (double)
     * @param num1
     * @param num2
     * @return (double) podiel num1/num2
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
     * Delenie dvoch cisel (float)
     * @param num1
     * @param num2
     * @return (float) podiel num1/num2
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
     * Druha odmocnina
     * @param num
     * @return odmocnina z cisla num
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
     * Vypocet faktorialu
     * @param num
     * @return faktorial cisla num
     */
    public int fact (int num) {
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
    		return (int)(x*Math.pow(10,ex));
    	return (int)x;
    	
    	/*
    	 * rekurzivne
    	 *  if(num < 0)
    	 *		return -1;
    	 *  return ((num == 0)? 1 : num*fact(--num));
    	*/
    }
    
    /**
     * N-ta mocnina
     * @param base zaklad
     * @param exponent
     * @return mocninu base na exponent
     */
    public double pow (double base, double exponent) {
    	return java.lang.Math.pow(base, exponent);
    }
}
