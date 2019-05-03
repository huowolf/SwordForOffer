package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author huowolf
 * @date 2019/4/26
 * @description
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 解题思路：定义两个栈，一个数据栈，一个辅助栈，用来保存当前的最小值
 */
public class MinStack {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);

        if(min.size() == 0 || node < min.peek()){
            min.push(node);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.pop();
    }

    public int min() {
        return min.peek();
    }



    @Test
    public void test(){
        push(3);
        push(4);

        int min = min();
        Assert.assertEquals(3,min);

        push(2);
        push(1);
        min = min();
        Assert.assertEquals(1,min);

        pop();
        min = min();
        Assert.assertEquals(2,min);

        pop();
        push(0);
        min = min();
        Assert.assertEquals(0,min);
    }
}
