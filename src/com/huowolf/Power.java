package com.huowolf;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by huowolf on 2019/3/16.
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {

    public double Power(double base, int exponent) {

        if(exponent == 0){
            return 1;
        }

        double result = 1;

        int number = exponent; //循环次数
        if(exponent < 0){
            number = -exponent;
        }
        for (int i = 1; i <= number; i++) {
            result = result*base;
        }
        if(exponent < 0){
            return 1/result;
        }
        return result;
    }

    @Test
    public void test(){

        assertEquals(1,Power(2,0),0.0001);
        assertEquals(4,Power(2,2),0.0001);
        assertEquals(0.12500,Power(2,-3),0.0001);
    }
}
