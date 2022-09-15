package com.markvdviert.main.util;

import java.util.Arrays;

public class Matrix {

    double[][] matrix;

    public Matrix(int rowSize, int ColumnSize, double fill){
        matrix = new[rowSize][ColumnSize];
        Arrays.fill(matrix, fill);
        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(matrix[i], fill);
        }
    }
    public Matrix(double[][] d ){
        this.matrix = d;
    }

    public Matrix(String s){
        //komt nog
    }

}
