package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author huowolf
 * @date 2019/5/1
 * @description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 */
public class IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null){
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int length = pushA.length;
        int k = 0;
        for (int i = 0; i < length; i++) {
            //如果栈不空
            if(!stack.isEmpty()){
                //取栈顶元素与出栈序列中元素做比较
                int top = stack.peek();
                if(top == popA[i]){
                    stack.pop();
                    continue;
                }else{
                    //如果入栈序列已经全部入栈完了，这时栈顶元素和出栈元素的结果不一致，那么返回false
                    if(k >= length){
                        return false;
                    }
                }
            }

            //让入栈序列元素进栈，直到和某个出栈序列元素相等时，此时开始寻找下一个出栈元素。
            int j;
            for (j = k; j < length; j++) {

                k++;
                if(pushA[j] != popA[i]){
                    stack.push(pushA[j]);
                }else{
                    break;
                }
            }

            //如果让全部入栈元素都入栈完了，竟然还没有找到一个出栈元素和入栈元素相等的，返回false
            if(j == length){
                return false;
            }
        }

        return true;
    }



    @Test
    public void test(){
        int [] pushA = {1,2,3,4,5};
        int [] popA = {4,5,3,2,1};

        boolean result = IsPopOrder(pushA, popA);
        Assert.assertTrue(result);

        int [] popB = {4,3,5,1,2};
        result = IsPopOrder(pushA, popB);
        Assert.assertFalse(result);

        int [] popC = {1,2,3,4,5};
        result = IsPopOrder(pushA, popC);
        Assert.assertTrue(result);


        //特别注意考虑只有一个元素的情况。
        int [] push1 = {1};
        int [] pop1= {2};
        result = IsPopOrder(push1, pop1);
        Assert.assertFalse(result);
    }
}
