package com.huowolf;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author huowolf
 * @date 2019/5/6
 * @description
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();

        int length = str.length();

        int k = 0;
        for (int i = k+1; i < length; i++) {
            
        }


        return null;
    }

    @Test
    public void test(){

        ArrayList<String> list = Permutation("abc");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
