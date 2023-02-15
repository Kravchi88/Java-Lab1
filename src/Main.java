import Lab1.Complex;
import Lab1.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2,2,new String[][]{{"1", "2"}, {"3", "4"}});
        System.out.println(matrix);
        System.out.println(matrix.transpose());
        System.out.println(matrix.multiplyByScalar(new Complex("2")));
    }
}