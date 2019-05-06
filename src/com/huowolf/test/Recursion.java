package com.huowolf.test;

import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/5/6
 * @description 理解递归
 */
public class Recursion {

    public void fun(int n){

        System.out.println("level"+n +":"+"first");
        if(n < 4){
            fun(n+1);
        }

        System.out.println("level"+n +":"+"second");
    }

    @Test
    public void test(){
        fun(1);
    }
}
