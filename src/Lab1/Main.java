package Lab1;

/**
 * In this class, instances of the Complex and Matrix classes are created,
 * as well as possible operations are performed on these objects.
 */
public class Main {
    /**
     * main method
     * @param args args
     */
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

        // create matrices
        Matrix matrix1 = new Matrix(2,2, new String[][]{{"1", "2"},{"3", "4"}});
        Matrix matrix2 = new Matrix(2,2, new String[][]{{"2", "4"},{"6", "8"}});

        System.out.println(matrix1);

        // actions
        System.out.println(matrix1.multiplyByScalar(new Complex("3")));
        System.out.println(matrix2.transpose());
        System.out.println(matrix1.add(matrix2));
        System.out.println(matrix1.sub(matrix2));
        System.out.println(matrix1.mul(matrix2));
        matrix1.setValueAt(0, 1, "5-4i");
        System.out.println(matrix1.getValueAt(0, 1));
    }
}
