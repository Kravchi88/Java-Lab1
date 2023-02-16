package Lab1;

import java.util.Objects;

/**
 * A special helper class for working with complex numbers and matrices.
 * All class methods have default or private access modifier.
 */
public final class Utils {

    /**
     * This method extracts the real part of a complex number from the given string.
     * @param fullNumber number in a+bi form
     * @return double
     */
    static double createRealPart(String fullNumber){
        String realPart = "";
        for (int i = 0; i < fullNumber.length(); i++){
            if (fullNumber.charAt(i) == '+' || fullNumber.charAt(i) == '-' && i != 0){
                break;
            }
            realPart = realPart.concat(fullNumber.substring(i, i+1));
        }
        if (countElementInString(realPart) == 0) { return Double.parseDouble(realPart); }
        else { return 0; }
    }

    /**
     * This method extracts the imaginary part of a complex number from the given string.
     * @param fullNumber number in a+bi form
     * @return double
     */
    static double createImaginaryPart(String fullNumber){
        if (Utils.countElementInString(fullNumber) == 0) { return 0; }
        else {
            int startIndex = 0;
            for (int i = fullNumber.length() - 1; i >= 0; i--){
                if (fullNumber.charAt(i) == '+'){
                    startIndex = i + 1;
                    break;
                } else if (fullNumber.charAt(i) == '-'){
                    startIndex = i;
                    break;
                }
            }
            String imaginaryPart = "";
            for (int i = startIndex; i < fullNumber.length() - 1; i++){
                imaginaryPart = imaginaryPart.concat(fullNumber.substring(i, i+1));
            }
            if (imaginaryPart.isEmpty()) {
                return 1;
            } else if (Objects.equals(imaginaryPart, "-")) {
                return -1;
            } else {
                return Double.parseDouble(imaginaryPart);
            }
        }
    }

    /**
     * This method creates a string for displaying a complex number in the a+bi form.
     * @param realPart real part
     * @param imaginaryPart imaginary part
     * @return String
     */
    static String createStringNumber(double realPart, double imaginaryPart){
        if (imaginaryPart == 0){
            return String.valueOf(realPart);
        } else if (realPart == 0){
            return imaginaryPart +"i";
        } else if (imaginaryPart == 1){
            return realPart+"+i";
        } else if (imaginaryPart == -1){
            return realPart+"-i";
        } else if (imaginaryPart > 0){
            return realPart+"+"+imaginaryPart+"i";
        } else {
            return realPart+""+imaginaryPart+"i";
        }
    }

    /**
     * This method returns the complex conjugate of the passed number.
     * @param num number to de conjugated
     * @return Complex
     */
    static Complex conjugateNumber(Complex num){
        return new Complex(Utils.createStringNumber(num.getRealPart(), num.getImaginaryPart()*(-1)));
    }

    /**
     * This method creates a matrix of complex numbers from a matrix of strings provided by the user.
     * @param lines number of lines
     * @param columns number of columns
     * @param stringMatrix matrix of strings
     * @return Complex[][]
     */
    static Complex[][] createComplexMatrix(int lines, int columns, String[][] stringMatrix){
        Complex[][] complexMatrix = new Complex[lines][columns];
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                complexMatrix[i][j] = new Complex(stringMatrix[i][j]);
            }
        }
        return complexMatrix;
    }

    /**
     * This method is called in the toString() method to display the matrix on the screen.
     * @param lines number of lines
     * @param columns number of columns
     * @param matrix matrix to be printed
     * @return String
     */
    static String printMatrix(int lines, int columns, Complex[][] matrix){
        String string = "";
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                string = string.concat(matrix[i][j].toString()+" ");
            }
            string = string.concat("\n");
        }
        return string;
    }

    /**
     * This method counts the number of characters i in a complex number
     * to determine the imaginary part of the complex number.
     * @param string string
     * @return integer
     */
    private static int countElementInString(String string){
        int counter = 0;
        for (char el : string.toCharArray()){
            if (el == 'i') counter++;
        }
        return counter;
    }
}
