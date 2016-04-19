package ivs.ivs2015.coculator.math;

public class MathLib {
    public double add (double num1, double num2) {
        return num1 + num2;
    }

    public float add (float num1, float num2) {
        return num1 + num2;
    }

    public int add (int num1, int num2) {
        return num1 + num2;
    }

    public double sub (double num1, double num2) {
        return num1 - num2;
    }

    public float sub (float num1, float num2) {
        return num1 - num2;
    }

    public int sub (int num1, int num2) {
        return num1 - num2;
    }

    public double mul (double num1, double num2) {
        return num1 - num2;
    }

    public float mul (float num1, float num2) {
        return num1 - num2;
    }

    public int mul (int num1, int num2) {
        return num1 - num2;
    }

    public double div (double num1, double num2) {
        if (num2 == 0) {
        	throw new ArithmeticException();
        }
        else {
            return num1/num2;
        }
    }

    public float div (float num1, float num2) {
        if (num2 == 0) {
            throw new ArithmeticException();
        }
        else {
            return num1/num2;
        }
    }

    public int div (int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException();
        }
        else {
            return num1/num2;
        }
    }
    
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
    
    public int fact (int num) {
    	return ((num == 0)? 1 : num*fact(--num));
    }
    
    public double pow (double base, double exponent) {
    	return java.lang.Math.pow(base, exponent);
    }
}
