package com.sanket.Array;

/*
    Problem Link - https://leetcode.com/problems/set-matrix-zeroes/
    Status - Accepted
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if (rows < 1) { return; }
        int cols = matrix[0].length;
        boolean isZeroRow = false;
        boolean isZeroCol = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isZeroCol = true;
                break;
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                isZeroRow = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 ||
                        matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isZeroCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isZeroRow) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }


    }

}