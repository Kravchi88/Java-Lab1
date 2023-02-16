package Lab1;

/**
 * This class allows you to create and work with matrices.
 */
public class Matrix {

    /**
     * This field stores the number of lines in the matrix.
     */
    private final int lines;

    /**
     * This field stores the number of columns in the matrix.
     */
    private final int columns;

    /**
     * This field stores the matrix.
     */
    private final Complex[][] complexMatrix;

    /**
     * External constructor when the matrix is given by the user.
     * @param lines number of lines
     * @param columns number of columns
     * @param stringMatrix matrix
     */
    public Matrix(int lines, int columns, String[][] stringMatrix){
        this.lines = lines;
        this.columns = columns;
        this.complexMatrix = new Complex[lines][columns];
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                complexMatrix[i][j] = new Complex(stringMatrix[i][j]);
            }
        }
    }

    /**
     * Internal constructor when the matrix is created as the program runs.
     * @param lines number of lines
     * @param columns number of columns
     */
    public Matrix(int lines, int columns){
        this.lines = lines;
        this.columns = columns;
        this.complexMatrix = new Complex[lines][columns];
    }

    @Override
    public String toString(){
        String string = "";
        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                string = string.concat(this.complexMatrix[i][j].toString()+" ");
            }
            string = string.concat("\n");
        }
        return string;
    }

    /**
     * This method assigns the passed value to a specific element of the matrix.
     * @param i index1
     * @param j index2
     * @param el element
     */
    public void setValueAt(int i, int j, String el) { complexMatrix[i][j] = new Complex(el); }

    /**
     * This method returns the value of a matrix element by its index.
     * @param i index1
     * @param j index2
     * @return Complex
     */
    public Complex getValueAt(int i, int j) { return complexMatrix[i][j]; }

    /**
     * This method multiplies a matrix by the given scalar value. Returns a new matrix object.
     * @param scalar scalar
     * @return Matrix
     */
    public Matrix multiplyByScalar(Complex scalar){
        Matrix newMatrix = new Matrix(this.lines, this.columns);
        for (int i = 0; i < newMatrix.lines; i++){
            for (int j = 0; j < newMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(this.complexMatrix[i][j].getRealPart(),
                        this.complexMatrix[i][j].getImaginaryPart()).mul(scalar);
            }
        }
        return newMatrix;
    }

    /**
     * This method transposes a matrix. Returns a new matrix object.
     * @return Matrix
     */
    public Matrix transpose(){
        Matrix newMatrix = new Matrix(this.columns, this.lines);
        for (int i = 0; i < this.lines; i++){
            for (int j = 0; j < this.columns; j++){
                newMatrix.complexMatrix[j][i] = new Complex(this.complexMatrix[i][j].getRealPart(),
                        this.complexMatrix[i][j].getImaginaryPart());
            }
        }
        return newMatrix;
    }

    /**
     * This method adds a matrix to another matrix. Returns a new matrix object.
     * @param secondMatrix second matrix
     * @return Matrix
     */
    public Matrix add(Matrix secondMatrix){
        if (this.lines != secondMatrix.lines || this.columns != secondMatrix.columns) {
            throw new ArithmeticException("You can not add these matrices. They have different size");
        }
        Matrix newMatrix = new Matrix(this.lines, this.columns);
        for (int i = 0; i < newMatrix.lines; i++){
            for (int j = 0; j < newMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(this.complexMatrix[i][j].getRealPart(),
                        this.complexMatrix[i][j].getImaginaryPart()).add(secondMatrix.complexMatrix[i][j]);
            }
        }
        return newMatrix;
    }

    /**
     * This method subtracts another matrix from a matrix. Returns a new matrix object.
     * @param secondMatrix second matrix
     * @return Matrix
     */
    public Matrix sub(Matrix secondMatrix){
        if (this.lines != secondMatrix.lines || this.columns != secondMatrix.columns) {
            throw new ArithmeticException("You can not sub these matrices. They have different size");
        }
        Matrix newMatrix = new Matrix(this.lines, this.columns);
        for (int i = 0; i < newMatrix.lines; i++){
            for (int j = 0; j < newMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(this.complexMatrix[i][j].getRealPart(),
                        this.complexMatrix[i][j].getImaginaryPart()).sub(secondMatrix.complexMatrix[i][j]);
            }
        }
        return newMatrix;
    }

    /**
     * This method multiplies a matrix by another matrix. Returns a new matrix object.
     * @param secondMatrix second matrix
     * @return Matrix
     */
    public Matrix mul(Matrix secondMatrix){
        if (this.columns != secondMatrix.lines){
            throw new ArithmeticException("You can not mul these matrices");
        }
        Matrix newMatrix = new Matrix(this.lines, secondMatrix.columns);
        for (int i = 0; i < this.lines; i++){
            for (int j = 0; j < secondMatrix.columns; j++){
                newMatrix.complexMatrix[i][j] = new Complex(0, 0);
                for (int k = 0; k < this.columns; k++){
                    Complex temp = this.complexMatrix[i][k].mul(secondMatrix.complexMatrix[k][j]);
                    newMatrix.complexMatrix[i][j] = newMatrix.complexMatrix[i][j].add(temp);
                }
            }
        }
        return newMatrix;
    }
}
