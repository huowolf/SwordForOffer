package com.huowolf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huowolf
 * @date 2019/4/9
 * @description 输入一个链表，输出该链表中倒数第k个结点。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindKthToTail {

    public static ListNode FindKthToTail(ListNode head,int k) {

        if(head==null || k==0){
            return null;
        }

        ListNode pre,p;
        pre = head;
        p = head;

        int i=0;
        while(i<k-1){   //pre指针要先走k-1步，保持pre和p保持k-1的距离
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null; //如果链表的节点数小于k,则会遍历到链表尾
            }
            i++;
        }

        while (pre.next!=null){
            p = p.next;
            pre = pre.next;
        }

        return p;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = FindKthToTail(head, 3);
        Assert.assertEquals(4,node.val);

        ListNode result = FindKthToTail(head, 7);
        Assert.assertEquals(null,result);
    }
}
