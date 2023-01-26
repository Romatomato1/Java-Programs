/** class to model a row * col matrix of doubles <br>
 * 
 * @author CSC 142 Fall 2018
 */

public class Matrix {

    private int row;
    private int col;

    // declare the instance variable that will hold the 2-dim array
    private double[][] myArr;

    /**Instantiate a ROW x COL matrix, empty
     */
    public Matrix(int row, int col) {
        if (row <= 0 || col <= 0){
            throw new IllegalArgumentException("Array Index out of bound");
        }
        this.row = row;
        this.col = col;
        myArr = new double[row][col];        
    }

    /** set the value of a particular element in the matrix
     * @param row the row of the element. 0 <= row < Matrix.ROW
     * @param col the column of the element.   0 <= col < Matrix.COL
     * @param value the value to be stored
     * @throws ArrayIndexOutOfBoundsException for invalid row or column
     */
    public void setValue(int row, int col, double value) 
    throws ArrayIndexOutOfBoundsException{
        // Why don't we have to test row/col for validity?    
        myArr[row][col] = value;
    }

    /** returns the value of a particular element in the matrix
     * @param row the row of the element. 0 <= row < Matrix.ROW
     * @param col the column of the element.   0 <= col < Matrix.COL
     * @throws ArrayIndexOutOfBoundsException for invalid row or column
     */
    public double getValue(int row, int col) 
    throws ArrayIndexOutOfBoundsException{
        return myArr[row][col];
    }

    /** swap 2 rows of this matrix
     * @param r1 one of the rows to swap.  0 <= r1 < Matrix.ROW
     * @param r2 the other row to swap.   0 <= r2 < Matrix.ROW
     * @throws ArrayIndexOutOfBoundsException for invalid row or column
     */
    public void swapRows(int r1, int r2) 
    throws ArrayIndexOutOfBoundsException{
        // double temp;
        // for (int i = 0; i < col; i++){
        // myArr[r1][i] = temp;
        // myArr[r1][i] = myArr[r2];
        // myArr[r2][i] = temp;
        // }
        // }

        double[] temp = myArr[r1];
        myArr[r1] = temp;
        myArr[r1] = myArr[r2];
        myArr[r2] = temp;
    }

    /** multiply one row by a non-zero constant
     * @param multiple the non-zero constant
     * @param row the row to change
     * @throws IllegalArgumentException if multiple is 0
     * @throws ArrayIndexOutOfBoundsException for invalid row
     */
    public void multiplyRow(double multiple, int row) 
    throws ArrayIndexOutOfBoundsException{
        if (multiple == 0) {
            throw new IllegalArgumentException("Multiple can not be 0");
        }
            for (int i = 0; i < col; i++){
            myArr[row][i] *= multiple;
        }
    }

    /** add row r1 into row r2. Equivalent to r2 += r1 
     * @param r1 the row to add  0 <= r1 < Matrix.ROW
     * @param r2 the row to add into.  0 <= r2 < Matrix.ROW.  This row will change.
     * @throws ArrayIndexOutOfBoundsException for invalid row
     */
    public void addRows (int r2, int r1) 
    throws ArrayIndexOutOfBoundsException{
        for (int i = 0; i < col; i++){
            myArr[r2][i] += myArr[r1][i];
        }
    }

    /**
     * set new row in the matrix
     * @param row the new row to insert
     * @param rIdx the index of this new row  0 <= rIdx < Matrix.ROW
     * @return the old row
     * @throws IllegalArgumentException if row is not the correct length of Matrix.COL
     * @throws ArrayIndexOutOfBoundsException for invalid row
     */
    public double[] replace(double[] row, int rIdx)
    throws ArrayIndexOutOfBoundsException{
        if (row == null){
            throw new IllegalArgumentException("Row doesn't exist.");
        }
        double[] oldRow = myArr[rIdx];
        myArr[rIdx] = row;
        return oldRow;
    }

    /**
     * Add 2 Matrices together and return a new Matrix
     * @param m the 2nd Matrix
     * @return the matrix sum of this + m
     */

    public Matrix sum(Matrix m){
        Matrix matrixNew = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                matrixNew.setValue(i,j,m.getValue(i,j) + myArr[i][j]);
            }
        }
        return matrixNew;
    }

    /** Return this matrix as a String of 3 rows of numbers in 4 columns
     */
    public String toString() {

    }
}  
