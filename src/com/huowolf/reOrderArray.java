package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/3/24
 * @description
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 解题思路：要保证相对位置不变，这就体现了稳定性。
 * 排序算法中，插入排序是稳定的。故采用插入排序算法。
 * 记录当前已排好位置的奇数元素的个数。(奇数区)
 * 当遇到奇数时，将该奇数元素依次与（奇数区到该元素之间的偶数元素）依次交换，
 * 直到把该元素交换到正确的奇数区位置。
 */
public class reOrderArray {

    public void reOrderArray(int [] array) {
        int k = 0;  //代表奇数区元素的个数

        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){

                //交换
                for (int j = i; j > k; j--) {
                    int temp = array[j-1];
                    array[j-1] =array[j];
                    array[j] = temp;
                }

                k++;
            }

        }


        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void test(){
        int [] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        Assert.assertArrayEquals(array,new int[]{1,3,5,7,2,4,6});
    }
}
