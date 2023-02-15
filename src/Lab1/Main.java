package Lab1;

public class Main {
    public static void main(String[] args) {

        // create complex as a+bi
        Complex num1 = new Complex("2+3i");
        Complex num2 = new Complex("-5-4i");

        System.out.println("real part of num1: " + num1.getRealPart());
        System.out.println("imaginary part of num2: " + num2.getImaginaryPart());

        // actions
        System.out.println("add result: " + num1.add(num2));
        System.out.println("sub result: " + num1.sub(num2));
        System.out.println("mul result: " + num1.mul(num2));
        System.out.println("div result: " + num1.div(num2));
        num1.showNumberInTrigonometricForm();


    }
}
