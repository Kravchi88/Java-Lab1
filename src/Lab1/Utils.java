package Lab1;

import java.util.Objects;

public final class Utils {

    public static double createRealPart(String fullNumber){
        String realPart = "";
        for (int i = 0; i < fullNumber.length(); i++){
            if (fullNumber.charAt(i) == '+' || fullNumber.charAt(i) == '-' && i != 0){
                break;
            }
            realPart = realPart.concat(fullNumber.substring(i, i+1));
        }
        if (countElementsInString(realPart, 'i') == 0) { return Double.parseDouble(realPart); }
        else { return 0; }
    }

    public static double createImaginaryPart(String fullNumber){
        if (Utils.countElementsInString(fullNumber, 'i') == 0) { return 0; }
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

    public static String createStringNumber(double realPart, double imaginaryPart){
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

    public static Complex conjugateNumber(Complex num){
        return new Complex(Utils.createStringNumber(num.getRealPart(), num.getImaginaryPart()*(-1)));
    }

    public static Complex[][] createComplexMatrix(int lines, int columns, String[][] stringMatrix){
        Complex[][] complexMatrix = new Complex[lines][columns];
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                complexMatrix[i][j] = new Complex(stringMatrix[i][j]);
            }
        }
        return complexMatrix;
    }

    public static String[][] createStringMatrix(int lines, int columns, Complex[][] complexMatrix){
        String[][] stringMatrix = new String[lines][columns];
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                stringMatrix[i][j] = Utils.createStringNumber(complexMatrix[i][j].getRealPart(),
                        complexMatrix[i][j].getImaginaryPart());
            }
        }
        return stringMatrix;
    }

    public static String printMatrix(int lines, int columns, Complex[][] matrix){
        String string = "";
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                string = string.concat(matrix[i][j].toString()+" ");
            }
            string = string.concat("\n");
        }
        return string;
    }

    public static int countElementsInString(String string, char element){
        int counter = 0;
        for (char el : string.toCharArray()){
            if (el == element) counter++;
        }
        return counter;
    }
}
