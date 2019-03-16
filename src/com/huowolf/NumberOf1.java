package com.huowolf;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by huowolf on 2019/3/2.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    //正解
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            //将1左移，判断对应位是否为1
            if((n & flag) != 0){
                count++;
            }

            flag = flag << 1;
        }
        return count;
    }


    //最优解
    public static int NumberOf1_version2(int n) {
        int count = 0;

        while (n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        assertEquals(1, NumberOf1(1));
        assertEquals(31,  NumberOf1(0x7FFFFFFF));
        assertEquals(32, NumberOf1(0xFFFFFFFF));
        assertEquals(1, NumberOf1(0x80000000));

    }

    @Test
    public void test(){

        int flag = 1;
        while(flag!=0){
            System.out.println(flag);
            flag = flag << 1;
        }
    }

    @Test
    public void testVesion2(){
        assertEquals(1, NumberOf1_version2(1));
        assertEquals(31,  NumberOf1_version2(0x7FFFFFFF));
        assertEquals(32, NumberOf1_version2(0xFFFFFFFF));
        assertEquals(1, NumberOf1_version2(0x80000000));
    }
}
