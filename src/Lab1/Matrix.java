package Lab1;

public class Matrix {
    private final int lines;
    private final int columns;
    private final Complex[][] complexMatrix;

    public Matrix(int lines, int columns, String[][] stringMatrix){
        this.lines = lines;
        this.columns = columns;
        this.complexMatrix = Utils.createComplexMatrix(lines, columns, stringMatrix);
    }

    public Matrix(int lines, int columns){
        this.lines = lines;
        this.columns = columns;
        this.complexMatrix = new Complex[lines][columns];
    }

    public String toString() { return Utils.printMatrix(lines, columns, complexMatrix); }

    public void setValueAt(int i, int j, String el) { complexMatrix[i][j] = new Complex(el); }

    public Complex getValueAt(int i, int j) { return complexMatrix[i][j]; }

    public Matrix multiplyByScalar(Complex scalar){
        Matrix newMatrix = new Matrix(this.lines, this.columns);
        for (int i = 0; i < newMatrix.lines; i++){
            for (int j = 0; j < newMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(Utils.createStringNumber
                        (this.complexMatrix[i][j].getRealPart(), this.complexMatrix[i][j].getImaginaryPart())).mul(scalar);
            }
        }
        return newMatrix;
    }

    public Matrix transpose(){
        Matrix newMatrix = new Matrix(this.columns, this.lines);
        for (int i = 0; i < this.lines; i++){
            for (int j = 0; j < this.columns; j++){
                newMatrix.complexMatrix[j][i] = new Complex(Utils.createStringNumber
                        (this.complexMatrix[i][j].getRealPart(), this.complexMatrix[i][j].getImaginaryPart()));
            }
        }
        return newMatrix;
    }

    public Matrix add(Matrix secondMatrix){
        if (this.lines != secondMatrix.lines || this.columns != secondMatrix.columns) {
            throw new ArithmeticException("You can not add these matrices. They have different size");
        }
        Matrix newMatrix = new Matrix(this.lines, this.columns);
        for (int i = 0; i < newMatrix.lines; i++){
            for (int j = 0; j < newMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(Utils.createStringNumber
                        (this.complexMatrix[i][j].getRealPart(), this.complexMatrix[i][j].getImaginaryPart())).
                        add(secondMatrix.complexMatrix[i][j]);
            }
        }
        return newMatrix;
    }

    public Matrix sub(Matrix secondMatrix){
        if (this.lines != secondMatrix.lines || this.columns != secondMatrix.columns) {
            throw new ArithmeticException("You can not sub these matrices. They have different size");
        }
        Matrix newMatrix = new Matrix(this.lines, this.columns);
        for (int i = 0; i < newMatrix.lines; i++){
            for (int j = 0; j < newMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(Utils.createStringNumber
                        (this.complexMatrix[i][j].getRealPart(), this.complexMatrix[i][j].getImaginaryPart())).
                        sub(secondMatrix.complexMatrix[i][j]);
            }
        }
        return newMatrix;
    }

    public Matrix mult(Matrix secondMatrix){
        if (this.columns != secondMatrix.lines){
            throw new ArithmeticException("You can not mult these matrices");
        }
        Matrix newMatrix = new Matrix(this.lines, secondMatrix.columns);
        for (int i = 0; i < this.lines; i++){
            for (int j = 0; j < secondMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex("0");
                for (int k = 0; k < this.columns; k++){
                    Complex temp = this.complexMatrix[i][k].mul(secondMatrix.complexMatrix[k][j]);
                    newMatrix.complexMatrix[i][j] = newMatrix.complexMatrix[i][j].add(temp);
                }
            }
        }
        return newMatrix;
    }
}
