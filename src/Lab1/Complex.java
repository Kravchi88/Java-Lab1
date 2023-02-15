package Lab1;

public class Complex {
    private final double realPart;
    private final double imaginaryPart;

    public Complex(String stringNumber) {
        this.realPart = Utils.createRealPart(stringNumber);
        this.imaginaryPart = Utils.createImaginaryPart(stringNumber);
    }

    public double getRealPart() { return realPart; }

    public double getImaginaryPart() { return imaginaryPart; }

    public String toString() { return Utils.createStringNumber(realPart, imaginaryPart); }

    public Complex add(Complex num){
        return new Complex(Utils.createStringNumber
                (this.realPart+num.realPart, this.imaginaryPart+num.imaginaryPart));
    }

    public Complex sub(Complex num){
        return new Complex(Utils.createStringNumber
                (this.realPart-num.realPart, this.imaginaryPart-num.imaginaryPart));
    }

    public Complex mul(Complex num){
        return new Complex(Utils.createStringNumber
                (this.realPart*num.realPart-
                        this.imaginaryPart*num.imaginaryPart, this.realPart*num.imaginaryPart+
                        this.imaginaryPart*num.realPart));
    }

    public Complex div(Complex num){
        if (num.realPart == 0 && num.imaginaryPart == 0){
            throw new ArithmeticException("You can not divide by zero");
        }
        Complex dividend = this.mul(Utils.conjugateNumber(num));
        Complex divider = num.mul(Utils.conjugateNumber(num));
        return new Complex(Utils.createStringNumber(dividend.realPart/divider.realPart,
                dividend.imaginaryPart/divider.realPart));
    }

    public void showNumberInTrigonometricForm(){
        double z1 = Math.abs(Math.sqrt(Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2)));
        double arg1 = Math.atan(this.imaginaryPart/this.realPart);
        if (z1!=1) { System.out.println("z = " + z1 + "(cos" + arg1 + ")+i(sin" + arg1 + ")"); }
        else { System.out.println("z = (cos" + arg1 + ")+i(sin" + arg1 + ")"); }
    }
}
