package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author huowolf
 * @date 2019/4/26
 * @description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class PrintMatrix {


    /**
     * 以螺旋矩阵的顺序依次输出
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int row = matrix.length;        //行数
        int col = matrix[0].length;     //列数

        ArrayList<Integer> res = new ArrayList<>();

        int left = 0, top = 0, right = col-1, bottom = row-1;

        while (left <= right && top<= bottom){

            //从左到右打印
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }

            //从上到下打印
            for (int i = top+1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }

            //从右向左打印(防止出现单行)
            if(top != bottom){
                for (int i = right-1; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
            }

            //从下向上打印(防止出现单列)
            if(left != right){
                for (int i = bottom-1; i > top; i--){
                    res.add(matrix[i][left]);
                }
            }

            left++;top++;right--;bottom--;
        }

        return res;
    }


    /**
     * 打印一个螺旋矩阵
     * 1   2    3  4
     * 12  13  14  5
     * 11  16  15  6
     * 10  9   8   7
     * @param n
     * @return
     */
    public int [][] printMatrix2(int n) {

        int left = 0, top = 0, right = n-1, bottom = n-1;

        int k = 1;
        int [][] matrix = new int[n][n];

        while (left <= right && top<= bottom){

            //从左到右打印
            for (int i = left; i <= right; i++){
                matrix[top][i] = k++;
            }

            //从上到下打印
            for (int i = top+1; i <= bottom; i++){
                matrix[i][right] = k++;
            }

            //从右向左打印
            for (int i = right-1; i >= left; i--){
                matrix[bottom][i] = k++;
            }

            //从下向上打印
            for (int i = bottom-1; i > top; i--){
                matrix[i][left] = k++;
            }

            left++;top++;right--;bottom--;
        }

        return matrix;
    }

    @Test
    public void testPrintMatrix(){
        int [][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        Integer [] arr = {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10};

        ArrayList<Integer> matrix1 = printMatrix(matrix);

        System.out.println(matrix1);

        Integer[] array = matrix1.toArray(new Integer[matrix1.size()]);
        Assert.assertArrayEquals(arr,array);
    }


    @Test
    public void testPrintMatrix2(){
        int[][] matrix2 = printMatrix2(4);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.printf(matrix2[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
