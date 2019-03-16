package com.huowolf;

import static org.junit.Assert.*;
/**
 * Created by huowolf on 2019/3/2.
 *
 * fibonacci数列的实用解法
 * 从下往上计算，避免重复计算
 */
public class Fibonacci {
    public static long fibonacci(int n){
        int[] result={0,1};
        if(n<2)
            return result[n];

        long fibNfirst = 1; //f(1)=1
        long fibNSecond = 0;//f(0)=0
        long fibN = 0;
        for(int i=2;i<=n;i++){
            fibN = fibNfirst + fibNSecond;

            fibNSecond = fibNfirst;
            fibNfirst = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        long result1 = fibonacci(3);
        System.out.println(result1);
        assertEquals(result1,2);

        long result2 = fibonacci(5);
        System.out.println(result2);
        assertEquals(result2,5);
    }




}
