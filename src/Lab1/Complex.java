package Lab1;

/**
 * This class allows you to create and work with complex numbers.
 */
public class Complex {

    /**
     * This field stores the real part of the complex number.
     */
    private final double realPart;

    /**
     * This field stores the imaginary part of the complex number.
     */
    private final double imaginaryPart;

    /**
     * External constructor when the number is given by the user.
     * @param stringNumber number in a+bi form
     */
    public Complex(String stringNumber) {
        this.realPart = Utils.createRealPart(stringNumber);
        this.imaginaryPart = Utils.createImaginaryPart(stringNumber);
    }

    /**
     * Internal constructor when the number is created as the program runs.
     * @param realPart real part
     * @param imaginaryPart imaginary part
     */
    public Complex(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Returns the real part of a complex number.
     * @return double
     */
    public double getRealPart() { return realPart; }

    /**
     * Returns the imaginary part of a complex number.
     * @return double
     */
    public double getImaginaryPart() { return imaginaryPart; }

    @Override
    public String toString() { return Utils.createStringNumber(realPart, imaginaryPart); }

    /**
     * This method adds another number to a complex number. Returns a new object of class Complex.
     * @param num second number
     * @return Complex
     */
    public Complex add(Complex num){
        return new Complex(this.realPart+num.realPart, this.imaginaryPart+num.imaginaryPart);
    }

    /**
     * This method subtracts another number from a complex number. Returns a new object of class Complex.
     * @param num second number
     * @return Complex
     */
    public Complex sub(Complex num){
        return new Complex(this.realPart-num.realPart, this.imaginaryPart-num.imaginaryPart);
    }

    /**
     * This method multiplies a complex number by another number. Returns a new object of class Complex.
     * @param num second number
     * @return Complex
     */
    public Complex mul(Complex num){
        return new Complex(this.realPart*num.realPart - this.imaginaryPart*num.imaginaryPart,
                this.realPart*num.imaginaryPart + this.imaginaryPart*num.realPart);
    }

    /**
     * This method divides a complex number by another number. Returns a new object of class Complex.
     * @param num second number
     * @return Complex
     */
    public Complex div(Complex num){
        if (num.realPart == 0 && num.imaginaryPart == 0){
            throw new ArithmeticException("You can not divide by zero");
        }
        Complex dividend = this.mul(Utils.conjugateNumber(num));
        Complex divider = num.mul(Utils.conjugateNumber(num));
        return new Complex(dividend.realPart/divider.realPart,
                dividend.imaginaryPart/divider.realPart);
    }

    /**
     * This method displays a complex number in trigonometric form.
     */
    public void showNumberInTrigonometricForm(){
        double z1 = Math.abs(Math.sqrt(Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2)));
        double arg1 = Math.atan(this.imaginaryPart/this.realPart);
        if (z1!=1) { System.out.println("z = " + z1 + "(cos" + arg1 + ")+i(sin" + arg1 + ")"); }
        else { System.out.println("z = (cos" + arg1 + ")+i(sin" + arg1 + ")"); }
    }
}
