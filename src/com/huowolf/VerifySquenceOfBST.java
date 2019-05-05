package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/5/3
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 解析思路：二叉搜索的特点：左子树小于根，右子树大于根
 * 二叉搜索树的后序遍历的最后一个节点就是根。
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {


        if(sequence.length <= 0){
            return false;
        }

        return Judge(sequence,0,sequence.length-1);
    }


    private boolean Judge(int[] sequence, int start, int end) {

        if(start >= end){
            return true;
        }

        int i = start;

        //找到以sequence[end]为根的左子树节点
        while(sequence[i] < sequence[end]){
            ++i;
        }

        //右子树节点理应比根节点值大
        for(int j = i; j < end; ++j){
            if(sequence[j] < sequence[end]){
                return false;
            }
        }

        //递归遍历左子树和右子树
        return Judge(sequence,0,i-1) && Judge(sequence,i,end-1);
    }


    @Test
    public void test(){
        int [] arr = {5,7,6,9,11,10,8};
        boolean result = VerifySquenceOfBST(arr);
        Assert.assertTrue(result);

        int [] arr2 = {7,4,6,5};
        boolean result2 = VerifySquenceOfBST(arr2);
        Assert.assertFalse(result2);
    }
}
